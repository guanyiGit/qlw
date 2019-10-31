package com.soholy.dogmanager.controller.device;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.device.DeviceRefModelInfo;
import com.soholy.dogmanager.service.device.DeviceManagerService;
import com.soholy.dogmanager.service.device.DeviceService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author guanY
 * @version 1.0.0
 * @ClassName DeviceController
 * @Description (设备相关)
 * @Date 2018年9月2日 下午4:20:53
 */
@Controller
@RequestMapping(value = "/biz/device")
public class DeviceController {

    /**
     * 临时生成文件名
     */
    private static final String excelTempFileName = "temp.xls";

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceManagerService deviceManagerService;

    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    /**
     * 导出设备信息
     *
     * @param paramStr 数据
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("/device/export")
    @RequestMapping(value = "/export/data", method = RequestMethod.POST)
    public ResponseEntity<byte[]> generateExcel(
            @RequestParam("paramStr") String paramStr,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        List<DeviceRefModelInfo> list = JSON.parseArray(paramStr, DeviceRefModelInfo.class);

        Workbook book = deviceService.generateExcel(list);

//        String realPath = request.getServletContext().getRealPath("/excel");
//        File file = new File(realPath + "/" + excelTempFileName);
//        response.setContentType("application/force-download");// 设置强制下载不打开
//        response.addHeader("Content-Disposition", "attachment;fileName=" + excelTempFileName);// 设置文件名
//        ServletOutputStream sos = response.getOutputStream();
//        book.write(sos);
//        sos.flush();
//        sos.close();

        String fileName=new String("设备信息表.xls".getBytes("utf-8"),"iso-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            book.write(bos);
        } finally {
            bos.close();
        }
        return new ResponseEntity<byte[]>(bos.toByteArray(),
                headers, HttpStatus.CREATED);
    }


    /**
     * @param file
     * @param userId 机构id
     * @return
     * @throws Exception
     * @Description (导入设备excel)
     */
    @RequiresPermissions("/device/import")
    @ResponseBody
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String excelUpload(@RequestParam(value = "file") MultipartFile file,
                              @RequestParam("orgId") Long orgId)
            throws Exception {
        if (file == null) {
            logger.info("file upload paras error");
            return new GlobalResult().failureJSON();
        }
        InputStream is = file.getInputStream();
        try {
            boolean bool = deviceService.addDeviceByImprot(is, orgId);
            return new GlobalResult().boolResultJSON(bool);
        } catch (Exception e) {
            return new GlobalResult().failureJSON(e.getMessage());
        }
    }

    /**
     * 模板下载
     *
     * @param userId
     * @param request
     * @return
     * @throws IOException
     */
    @RequiresPermissions("/export")
    @ResponseBody
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ResponseEntity<byte[]> export(@RequestParam("userId") Long userId, HttpServletRequest request) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        String fileName = "device.xls";
        String realPath = request.getServletContext().getRealPath("/excel");
        File file = new File(realPath + "/" + fileName);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    /**
     * @param deviceStatus 设备状态 【0禁用，1启用,2注销】
     * @param keyWord      搜索关键字【品牌，编号】
     * @param offset       页码
     * @param limit        每页显示数量
     * @return
     * @throws Exception
     * @Description (查看设备列表)
     */
    @RequiresPermissions("/device/list")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "deviceStatus", required = false) Integer deviceStatus,
                       @RequestParam(value = "keyWord", required = false) String keyWord,
                       @RequestParam(value = "offset", required = false) int offset,
                       @RequestParam(value = "limit", required = false) int limit
    ) throws Exception {

//        PageHelper.offsetPage(offset, limit);
        PageHelper.startPage(offset, limit);
        List<DeviceRefModelInfo> deviceList = deviceService.findDeviceListByStatusAndKeyWord(deviceStatus, null, keyWord);
        PageInfo<DeviceRefModelInfo> page = new PageInfo<>(deviceList);
        return new GlobalResult().successJSON(page);
    }


    /**
     * 批量修改设备激活状态
     *
     * @param deviceIds
     * @param status    设备状态 【0禁用，1启用,2注销】
     * @return
     * @throws Exception
     */
    @RequiresPermissions("/device/list")
    @ResponseBody
    @RequestMapping(value = "/lists/{status}")
    public String modifyStatuss(@RequestParam("deviceIds") List<Long> deviceIds,
                                @PathVariable("status") Integer status) throws Exception {
        boolean bool = deviceService.modifyDeviceStatusByids(deviceIds, status);
        return new GlobalResult().boolResultJSON(bool);
    }

    /**
     * @param deviceId 设备id
     * @param status   设备状状态
     * @return
     * @throws Exception
     * @Description (启用禁用设备)
     */
    @RequiresPermissions("/{deviceId}/{status}")
    @ResponseBody
    @RequestMapping(value = "/{deviceId}/{status}", method = RequestMethod.PUT)
    public String modifyStatus(@PathVariable(value = "deviceId") Long deviceId,
                               @PathVariable(value = "status") Integer status) throws Exception {
        boolean bool = deviceService.modifyDeviceStatusByid(deviceId, status);
        return new GlobalResult().boolResultJSON(bool);
    }

    /**
     * @param deviceId 设备id
     * @return
     * @throws Exception
     * @Description (修改设备信息)
     */
    //@RequiresPermissions("/device/{deviceId}")
    @ResponseBody
    @RequestMapping(value = "/{deviceId}", method = RequestMethod.PUT)
    public String update(@PathVariable(value = "deviceId") Long deviceId, TDevice tDevice) throws Exception {

        boolean bool = deviceService.modifyByid(tDevice);
        return new GlobalResult().boolResultJSON(bool);
    }

    /**
     * 根据设备编号模糊查询设备列表
     *
     * @param keyWord  设备编号  like
     * @param isActive 是否只查未注册的设备
     */
    @RequestMapping(value = "/search/{keyWord}")
    @ResponseBody
    public String search(@PathVariable("keyWord") String keyWord, @RequestParam("isActive") boolean isActive) {
        return new GlobalResult().objResultJSON(deviceService.findDevicesLikeDeviceNum(keyWord, isActive));
    }


    /**
     * @param dogOwnerId 犬主id
     * @return
     * @throws Exception
     * @Description (根据犬主id查设备信息)
     */
    //@RequiresPermissions("/device/dogOwners/{dogOwnerId}")
    @ResponseBody
    @RequestMapping(value = "/dogOwners/{dogOwnerId}", method = RequestMethod.GET)
    public String viewByDogOwnerId(@PathVariable(value = "dogOwnerId") Long dogOwnerId) throws Exception {
        List<TDevice> tDevices = deviceService.findDeviceByDogOwnerId(dogOwnerId);
        return new GlobalResult().successJSON(tDevices);
    }


    /**
     * http://localhost:9000/biz/device/register/imei?deviceBrand=qlw_ll&deviceBatch=simple     * @param imei 设备imei号
     *
     * @param deviceBrand 品牌信息 可没有
     * @param deviceBatch 批次信息 可没有
     * @return
     * @throws Exception
     * @Description (设备注册)
     */
    @ResponseBody
    @RequestMapping(value = "/register/{imei}", method = RequestMethod.GET)
    public String register(@PathVariable(value = "imei") String imei,
                           String deviceBrand,
                           String deviceBatch
    ) throws Exception {

        if (StringUtils.isNotBlank(imei)) {
            return new GlobalResult().successJSON(deviceService.register(imei, deviceBrand, deviceBatch));
        }
        return new GlobalResult().failureJSON();
    }


    /**
     * 设备删除
     *
     * @param deviceIdIot
     * @return
     */
    @RequestMapping(value = "/logoutDevice/{deviceIdIot}")
    @ResponseBody
    public String logoutDevice(@PathVariable("deviceIdIot") String deviceIdIot) {
        return new GlobalResult().successJSON(deviceService.deleteDeviceByIotId(deviceIdIot));
    }


    /**
     * e根据设备id查询设备厂商和型号信息设备
     *
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/other/{deviceId}", method = RequestMethod.GET)
    @ResponseBody
    public String devieOtherInfo(@PathVariable long deviceId) {
        return new GlobalResult().objResultJSON(deviceService.findDeviceOtherInfoByid(deviceId));
    }

}
