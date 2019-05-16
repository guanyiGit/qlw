package com.soholy.dogmanager.controller.dogCard;

import com.github.pagehelper.StringUtil;
import com.soholy.dogmanager.common.exception.GlobalException;
import com.soholy.dogmanager.common.pojo.TableSplitResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.common.utils.Md5Encode;
import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.dogCard.*;
import com.soholy.dogmanager.exception.DataMismatchException;
import com.soholy.dogmanager.exception.SubmitRepeatException;
import com.soholy.dogmanager.mapper.dogCard.DogCardMapper;
import com.soholy.dogmanager.pojo.dogCard.InertDogCard;
import com.soholy.dogmanager.service.dogCard.DogCardService;
import com.soholy.dogmanager.service.member.impl.CodeFactory;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//犬证相关
@Controller
@RequestMapping("/biz/dogCard")
public class DogCardController {
    private static final Logger logger = Logger.getLogger(DogCardController.class);
    @Autowired
    DogCardService dogCardService;
    @Autowired
    DogCardMapper dogCardMapper;

    //办理生成犬证
    @RequiresPermissions("/dogCard/insertDogCard")
    @RequestMapping("/insertDogCard")
    @ResponseBody
    public ResponseEntity<String> insertDogCard(@RequestBody InertDogCard inertDogCard, HttpServletRequest request) {
        logger.debug("[犬证服务][生成犬证]：" + "inertDogCard:" + inertDogCard);
        String clientIp = request.getHeader("x-forwarded-for");
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
        try {
            dogCardService.insertDogCard(inertDogCard, clientIp);
            logger.info("[犬证服务][生成犬证]：生成犬证成功！");
        } catch (SubmitRepeatException e) {
            return new ResponseEntity<>("000133", "重复提交！");
        } catch (DataMismatchException e) {
            return new ResponseEntity<>("000144", "参数不匹配！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000131", "生成犬证失败！");
        } catch (org.apache.http.ParseException e) {
            logger.info("[犬证服务][办理犬证]：服务器异常，发送密码短信失败！");
            return new ResponseEntity<>("000132", "发送密码短信失败！");
        } catch (IOException e) {
            logger.info("[犬证服务][办理犬证]：发送密码短信失败！");
            return new ResponseEntity<>("001133", "发送密码短信失败！");
        } catch (URISyntaxException e) {
            logger.info("[犬证服务][办理犬证]：服务器异常，发送密码短信失败！");
            return new ResponseEntity<>("000134", "发送密码短信失败！");
        }
        return new ResponseEntity<String>("生成犬证成功！");
    }

    //生成犬证号
    @RequestMapping("/generateDogCard")
    @ResponseBody
    public String generateDogCard() {
        return CodeFactory.generateCode(4, true);
    }

    /**
     * 犬证审核
     */
//    @RequiresPermissions("/dogCard/dogCardAudit")
    @RequestMapping("/dogCardAudit")
    @ResponseBody
    public ResponseEntity dogCardAudit(@RequestBody InertDogCard inertDogCard) {
        //Long dogId,Integer status,Integer lssueOrgId,Long lssuerId,String dogCardNum,String reason,Date startTime,Date endTime
        try {
            dogCardService.dogCardAudit(inertDogCard);
            logger.info("犬证审核成功！");
        }catch (SubmitRepeatException e) {
            return new ResponseEntity<>("000133", "重复提交！");
        } catch (Exception e) {
            return new ResponseEntity<>("000211", "犬证审核失败！");
        }
        return new ResponseEntity<>("000000", "犬证审核成功！");
    }

    //查询犬的所有信息
    @RequiresPermissions("/dogCard/selectDogCardInfo")
    @RequestMapping("/selectDogCardInfo")
    @ResponseBody
    public ResponseEntity<DogAllInfo> selectDogCardInfo(HttpServletRequest request, String cardNum, Long dogId) {//cardNum既可以是免疫证号
        logger.debug("[犬证服务][查询犬信息]：" + "cardNum:" + cardNum + " dogId:" + dogId);
        DogAllInfo dogAllInfo = new DogAllInfo();
        try {
            if (StringUtil.isEmpty(cardNum)) {
                cardNum = null;
            } else {
//                cardNum = new String(request.getParameter("cardNum").getBytes("ISO-8859-1"), "UTF-8");
            }
            dogAllInfo = dogCardService.selectDogCardInfo(cardNum, dogId);
            logger.info("[犬证服务][查询犬信息]：查询犬信息成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000101", "查询犬信息失败！");
        }
        return new ResponseEntity<DogAllInfo>(dogAllInfo);
    }

    @RequiresPermissions("/dogCard/delectPic")
    @RequestMapping("/delectPic")
    @ResponseBody
    /**
     * 根据犬图id删犬图
     */
    public ResponseEntity delectPic(Long picId) {
        try {
            dogCardService.delectPic(picId);
            logger.info("删除犬只图片成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000200", "删除犬只图片失败！");
        }
        return new ResponseEntity<>("000000", "删除犬只图片成功！");
    }

    /**
     * 根据设备编号查询犬的所有信息
     *
     * @param request
     * @param deviceNum 设备编号
     * @return
     */
    //@RequiresPermissions("/dogCard/selectDogCardInfoByDevice")
    @RequestMapping("/selectDogCardInfoByDevice")
    @ResponseBody
    public ResponseEntity<DogAllInfo> selectDogCardInfoByDevice(HttpServletRequest request, String deviceNum) {
        logger.debug("[犬证服务][查询犬信息]：" + "deviceNum:" + deviceNum);
        DogAllInfo dogAllInfo = new DogAllInfo();
        try {
            if (StringUtil.isEmpty(deviceNum)) {
                deviceNum = null;
            }
            dogAllInfo = dogCardService.selectDogCardInfoByDevice(deviceNum);
            logger.info("[犬证服务][查询犬信息]：查询犬信息成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000101", "查询犬信息失败！");
        }
        return new ResponseEntity<DogAllInfo>(dogAllInfo);
    }

    /**
     * 根据设备编号查询犬的所有信息
     *
     * @param imei
     * @return
     */
    @RequestMapping("/selectDogCardInfoByImei")
    @ResponseBody
    public ResponseEntity<DogAllInfo> selectDogCardInfoByDevice(String imei) {
        logger.debug("[犬证服务][查询犬信息]：" + "imei:" + imei);
        DogAllInfo dogAllInfo = new DogAllInfo();
        try {
            if (StringUtil.isEmpty(imei)) {
                imei = null;
            }
            dogAllInfo = dogCardService.selectDogCardInfoByDeviceImei(imei);
            logger.info("[犬证服务][查询犬信息]：查询犬信息成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000101", "查询犬信息失败！");
        }
        return new ResponseEntity<DogAllInfo>(dogAllInfo);
    }

    /**
     * 根据设备编号查询犬的所有信息
     *
     * @param deviceIds
     * @return
     */
    @RequestMapping("/selectDogCardInfoByImeis")
    @ResponseBody
    public ResponseEntity<List<DogAllInfo>> selectDogCardInfoByDevices(@RequestBody List<String> deviceIds) {
        logger.debug("[犬证服务][查询犬信息]：" + "deviceIds:" + deviceIds);
        List<DogAllInfo> dogAllInfos = new ArrayList<>();
        try {
            if (deviceIds == null || deviceIds.size() ==0 ) {
                deviceIds = null;
            }
            dogAllInfos = dogCardService.selectDogCardInfoByDeviceImeis(deviceIds);
            logger.info("[犬证服务][查询犬信息]：查询犬信息成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000101", "查询犬信息失败！");
        }
        return new ResponseEntity<List<DogAllInfo>>(dogAllInfos);
    }

    //犬证办理列表查询
    @RequiresPermissions("/dogCard/selectDogCardHandleList")
    @RequestMapping("/selectDogCardHandleList")
    @ResponseBody
    public TableSplitResult selectDogCardHandleList(HttpServletRequest request, Integer status, Integer orgId, String input, Integer num, Integer size) {
        logger.debug("[犬证服务][犬证办理列表查询]：" + "input:" + input + " num:" + num + " size:" + size);
        if (input != null && input.isEmpty()) {
            input = null;
        }
//        Map<String,Object> map = new HashMap<>();
        List<DogCardRelatedInfo> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        TableSplitResult result = new TableSplitResult();
        try {
            if (StringUtil.isEmpty(input)) {
                input = null;
            } else {
//                input = new String(request.getParameter("input").getBytes("ISO-8859-1"), "UTF-8");
            }
            list = dogCardService.selectDogInfos(status, orgId, input, num, size);
            pageInfo = dogCardService.selectDogInfosPage(status, orgId, input, num, size);
            result.setPage(pageInfo.getPageNum());
            result.setTotal(pageInfo.getTotalCount());
            result.setRows(list);
//            map.put("dogInfos",list);
//            map.put("page",pageInfo);
            logger.info("[犬证服务][犬证办理列表查询]：犬证办理列表查询成功！");
        } catch (Exception e) {
            return new TableSplitResult();
        }
        return result;
    }

    //犬证续期
    @RequiresPermissions("/dogCard/updateCardDate")
    @RequestMapping("/updateCardDate")
    @ResponseBody
    public ResponseEntity<String> updateCardDate(Long dogId, String endDate) {
        logger.debug("[犬证服务][犬证续期]：" + "dogId:" + dogId + " endDate:" + endDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(endDate);
        } catch (ParseException e) {
            return new ResponseEntity<String>("000103", "日期转换失败！");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 24);// 24小时制
        date = cal.getTime();
        try {
            dogCardService.updateCardDate(dogId, date);
            logger.info("[犬证服务][犬证续期]：犬证续期成功！");
        } catch (ServerException e) {
            return new ResponseEntity<String>("000103", "犬证续期失败！");
        }
        return new ResponseEntity<String>("犬证续期成功！");
    }

    //查询电子犬证
    @RequiresPermissions("/dogCard/selectElectronicDogCard")
    @RequestMapping("/selectElectronicDogCard")
    @ResponseBody
    public ResponseEntity<List<ElectronicDogCard>> selectElectronicDogCard(Long userId) {
        logger.debug("[犬证服务][查询电子犬证]：" + "userId:" + userId);
        List<ElectronicDogCard> list = new ArrayList<>();
        try {
            list = dogCardService.selectElectronicDogCard(userId);
            logger.info("[犬证服务][查询电子犬证]：电子犬证查询成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000104", "电子犬证查询失败！");
        }
        return new ResponseEntity<List<ElectronicDogCard>>(list);
    }

    //查查询条件
    //@RequiresPermissions("/dogCard/selectConditions")
    @RequestMapping("/selectConditions")
    @ResponseBody
    public ResponseEntity<List<Conditions>> selectConditions(Integer logg) {
        logger.debug("[犬证服务][查查询条件]：" + "logg:" + logg);
        List<Conditions> list = new ArrayList<>();
        try {
            list = dogCardService.selectConditions(logg);
            logger.info("[犬证服务][查查询条件]：查询条件查询成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000105", "查询条件失败！");
        }
        return new ResponseEntity<List<Conditions>>(list);
    }

    //根据设备编号查犬id
    //@RequiresPermissions("/dogCard/selectDogIdByDeviceId")
    @RequestMapping("/selectDogIdByDeviceId")
    @ResponseBody
    public ResponseEntity<Long> selectDogIdByDeviceId(String deviceNumber) {
        logger.debug("[犬证服务][查查询条件]：" + "deviceNumber:" + deviceNumber);
        Long dogId = null;
        try {
            dogId = dogCardService.selectDogIdByDeviceId(deviceNumber);
        } catch (ServerException e) {
            return new ResponseEntity<>("000117", "根据设备编号查犬id失败！");
        }
        return new ResponseEntity<Long>(dogId);
    }

    //查询所有免疫证号
    //@RequiresPermissions("/dogCard/selectImmuneCardNums")
    @RequestMapping("/selectImmuneCardNums")
    @ResponseBody
    public ResponseEntity<List<String>> selectImmuneCardNums(String input) {
        List<String> list = new ArrayList<String>();
        try {
            list = dogCardService.selectImmuneCardNums(input);
        } catch (ServerException e) {
            return new ResponseEntity<>("000117", "根据设备编号查犬id失败！");
        }
        return new ResponseEntity<List<String>>(list);
    }

    //根据设备编号查设备id
    //@RequiresPermissions("/dogCard/selectDiviceIdByNum")
    @RequestMapping("/selectDiviceIdByNum")
    @ResponseBody
    public ResponseEntity<Integer> selectDiviceIdByNum(String deviceNumber) {
        logger.debug("[犬证服务][查设备id]：" + "deviceNumber:" + deviceNumber);
        Integer id = null;
        try {
            id = dogCardService.selectDeviceId(deviceNumber);
        } catch (ServerException e) {
            return new ResponseEntity<>("000117", "根据设备编号查设备id失败！");
        }
        return new ResponseEntity<Integer>(id);
    }


    //根据图片url查id
    @RequestMapping("/selectIdsByurl")
    @ResponseBody
    public ResponseEntity<List<Long>> selectIdsByurl(@RequestBody List<String> urls) {
        logger.debug("[根据图片url查图片id]：" + "urls:" + urls);
        List<Long> list = new ArrayList<Long>();
        try {
            for (int i = 0; i < urls.size(); i++) {
                Long id = dogCardMapper.selectIdsByurl(urls.get(i));
                list.add(id);
            }
        } catch (Exception e) {
            System.out.print(e);
            return new ResponseEntity<>("000127", "根据设备编号查设备id失败！");
        }
        return new ResponseEntity<List<Long>>(list);
    }

    /**
     * 根据设备编号查询犬信息
     *
     * @param request
     * @param deviceNum 设备编号
     * @return 犬信息
     */
    //@RequiresPermissions("/dogCard/findDogIdbyDeviceNum")
    @RequestMapping("/findDogInfobyDeviceNum")
    @ResponseBody
    public ResponseEntity<TDogInfo> fondDogInfoByDeviceNum(HttpServletRequest request, @RequestParam String deviceNum) {
        logger.debug("[犬证服务][查询犬信息]：" + "deviceNum:" + deviceNum);
        try {
            if (StringUtil.isEmpty(deviceNum)) {
                deviceNum = null;
            }
            TDogInfo tDogInfo = dogCardService.fondDogInfoByDeviceNum(deviceNum);
            logger.info("[犬证服务][查询犬信息]：查询犬信息成功！");
            return new ResponseEntity<TDogInfo>(tDogInfo);
        } catch (Exception e) {
            return new ResponseEntity<>("000101", "查询犬信息失败！");
        }
    }


    /**
     * 查看设备绑定情况
     *
     * @param imei
     * @return
     */
    @RequestMapping(value = "/deviceBandInfo/{imei}", method = RequestMethod.GET)
    @ResponseBody
    public String findDeviceBindInfo(@PathVariable String imei) {
        GlobalResult globalResult = new GlobalResult();
        return globalResult.resultJSON(dogCardService.findDeviceBindInfo(imei));
    }

    /**
     * 绑定设备
     *
     * @param DeviceId
     * @param dogId
     * @return
     */
    @RequestMapping(value = "/bindDevice", method = RequestMethod.POST)
    @ResponseBody
    public String bindDeviceById(@RequestParam long DeviceId, @RequestParam long dogId) {
        return new GlobalResult().boolResultJSON(dogCardService.bindDeviceByDeviceId(DeviceId, dogId));
    }

    /**
     * 绑定设备
     *
     * @param imei
     * @param dogId
     * @return
     */
    @RequestMapping(value = "/bindDevice/imei", method = RequestMethod.POST)
    @ResponseBody
    public String bindDeviceByImei(@RequestParam String imei, @RequestParam long dogId) {
        GlobalResult globalResult = new GlobalResult();
        try {
            boolean flag = dogCardService.bindDeviceByDeviceImei(imei, dogId);
            return globalResult.boolResultJSON(flag);
        } catch (GlobalException e) {
            return globalResult.failureJSON(e.getMessage());
        }
    }

    /**
     * 绑定设备
     * 2019-04-08 修改，绑定设备时需要设备密码
     * @param imei
     * @param dogId
     * @param devicePwd
     * @return
     */
    @RequestMapping(value = "/bindDevice/imei2", method = RequestMethod.POST)
    @ResponseBody
    public String bindDeviceByImei(@RequestParam String imei, @RequestParam long dogId, @RequestParam String devicePwd) {
        GlobalResult globalResult = new GlobalResult();
        try {
            boolean flag = dogCardService.bindDeviceByDeviceImei(imei, dogId,devicePwd);
            return globalResult.boolResultJSON(flag);
        } catch (GlobalException e) {
            return globalResult.failureJSON(e.getMessage());
        }
    }


    /**
     * 查询犬的信息 参数传其一
     *
     * @param immuneCardNum 免疫证号
     * @param seqId         免疫证id
     * @return
     */
    @RequestMapping(value = "/viewDogAllInfo", method = RequestMethod.GET)
    @ResponseBody
    public String viewDogAllInfo(@RequestParam(required = false) String immuneCardNum, @RequestParam(required = false) Integer seqId) {
        return new GlobalResult().resultJSON(dogCardService.findDogAllInfoByImcardNumOrSeqId(immuneCardNum, seqId));
    }

    /**
     * 根据免疫证号检验并查询相关信息
     *
     * @param immuneCardNum 免疫证号
     * @param dogOwnerName  犬主姓名
     * @param phone         犬主电话
     * @param cardType      证件类型
     * @param cardNum       证件号码
     * @return
     */
    @RequestMapping(value = "/handle/checkd", method = RequestMethod.GET)
    @ResponseBody
    public String checkdAndHandle(@RequestParam String immuneCardNum,
                                  @RequestParam String dogOwnerName,
                                  @RequestParam String phone,
                                  @RequestParam int cardType,
                                  @RequestParam String cardNum) {

        GlobalResult result = new GlobalResult();

        try {
            List<DogAndDogOwnerInfo> list = dogCardService.findAndCheckdCardInfoByImmuneNum(immuneCardNum, dogOwnerName, phone, cardType, cardNum);
            return result.successJSON(list);
        } catch (GlobalException e) {
            return result.failureJSON(e.getMessage());
        }
    }


    @RequestMapping(value = "/initPassword", method = RequestMethod.GET)
    @ResponseBody
    public String initPassword(String acc) {
        String password = Md5Encode.getCredentials(acc, "123456").toString();
        try {
            dogCardMapper.initPassword(acc, password);
            return "成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解绑设备
     * @param dogId 犬id
     * @param deviceId 设备id
     * @return
     */
    @RequestMapping(value = "/unBindDevice", method = RequestMethod.POST)
    @ResponseBody
    public String unBindDevice(long dogId, long deviceId) {
        return new GlobalResult().boolResultJSON(dogCardService.unbindDeviceById(dogId,deviceId));

    }
}

