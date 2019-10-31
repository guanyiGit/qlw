package com.soholy.dogmanager.service.device.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.entity.device.DeviceRefModelInfo;
import com.soholy.dogmanager.entity.device.DeviceRefOrg;
import com.soholy.dogmanager.entity.device.ExportExcel;
import com.soholy.dogmanager.mapper.*;
import com.soholy.dogmanager.pojo.device.DogRefDevice;
import com.soholy.dogmanager.service.device.DeviceManagerService;
import com.soholy.dogmanager.service.device.DeviceService;
import com.soholy.dogmanager.utils.ExcelUtile;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author guanY
 * @version 1.0.0
 * @ClassName DeviceServiceImpl
 * @Description (设备相关)
 * @Date 2018年8月20日 下午2:07:12
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    static Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

    @Value("${iot.interface.register}")
    private String registerUrl;

    @Autowired
    private TDeviceFactoryMapper tDeviceFactoryMapper;

    @Autowired
    private TDeviceModelMapper tDeviceModelMapper;

    @Autowired
    private TDeviceMapper tDeviceMapper;

    @Autowired
    private TUsersMapper tUsersMapper;

    @Autowired
    private DeviceManagerService deviceManagerService;

    @Autowired
    private TDeviceDataMapper tDeviceDataMapper;

    public List<DeviceRefModelInfo> findDeviceListByStatusAndKeyWord(Integer deviceStatus, Integer deviceType, String serchKey) {
        return tDeviceMapper.findDeviceListByStatusAndKeyWord(deviceStatus, deviceType, serchKey);
    }

    @Override
    public TDevice findDeviceByNum(String deviceNum) {
        TDeviceExample example = new TDeviceExample();
        example.createCriteria().andDeviceNumberEqualTo(deviceNum);
        List<TDevice> dList = tDeviceMapper.selectByExample(example);
        if (dList != null && dList.size() == 1) {
            return dList.get(0);
        }
        return null;
    }

    @Override
    public TDevice findDeviceByIMEI(String imei) {
        TDeviceExample example = new TDeviceExample();
        example.createCriteria().andImeiEqualTo(imei);
        List<TDevice> dList = tDeviceMapper.selectByExample(example);
        if (dList != null && dList.size() == 1) {
            return dList.get(0);
        }
        return null;
    }

    @Override
    public List<TDevice> findDeviceListByIds(List<Long> deviceIdList) {
        return tDeviceMapper.findDeviceListByIds(deviceIdList);
    }

    @Override
    public boolean addDeviceByImprot(InputStream is, long orgId) throws Exception {
        if (is == null) {
            return false;
        }
        int startRowNum = 4;//开始行 0开始
        int endRowNum = -1;//最后列
        int startCallNum = 1;//开始列
        int endCallNum = 9;//最后行
        List<TDevice> deviceList = null;
        // 从第5行开始读
        Workbook excelBk = ExcelUtile.createExcel(is);
        Map<String, Map<Integer, Map<Integer, String>>> excel = ExcelUtile.raedExcel(excelBk, startRowNum, endRowNum,
                startCallNum, endCallNum, false);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Entry<String, Map<Integer, Map<Integer, String>>> sheetEntry : excel.entrySet()) {
            String sheetName = sheetEntry.getKey();
            if (StringUtils.isBlank(sheetName) || !"设备信息表".equals(sheetName)) {// 表名称限制
                continue;
            }
            deviceList = new ArrayList<TDevice>();
            for (Entry<Integer, Map<Integer, String>> rowEntry : sheetEntry.getValue().entrySet()) {
                if (rowEntry == null) {
                    continue;
                }
                Integer rowNum = rowEntry.getKey();
                Map<Integer, String> call = rowEntry.getValue();

                if (call.entrySet().stream()
                        .noneMatch(x -> StringUtils.isNotBlank(x.getValue()))) {
                    logger.warn("单元格格式不对，有空存在！");
                    break;
//                    throw new RuntimeException("单元格格式不对，有空存在！");
                }

                String deviceName = call.get(startCallNum);//名称
                String deviceNo = call.get(startCallNum + 1);//编号
                String iMei = call.get(startCallNum + 2);//imei
                String factoryNo = call.get(startCallNum + 3);//厂商编号
                String modelNo = call.get(startCallNum + 4);//产品型号
                String batch = call.get(startCallNum + 5);//批次
                String brand = call.get(startCallNum + 6);//品牌名称
                Date productionTime = null;//出厂日期

                try {
                    productionTime = sdf.parse(call.get(startCallNum + 7));
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new RuntimeException("日期格式不对，请以yyyy/MM/dd格式!");
                }


                if (iMei == null || iMei.length() < 10) {
                    logger.error("导入设备信息，设备imei信息错误[长度不够或格式错误],rowNum:" + rowNum);
                    throw new RuntimeException("导入设备信息，设备imei信息错误[长度不够或格式错误]");
                }

                int factoryId = 0;
                int modelId = 0;

//                // 查询设备厂商信息
//                TDeviceFactory tDeviceFactory = this.saveAndFandDeviceFactoryByNum(factoryNum);//查询名称的厂商信息，没有则添加，否则直接返回
//                // 查询设备型号信息
//                TDeviceModel tDeviceModel = this.saveAndFandDeviceModelByNum(modelNum);//查询该设备名称设备信息，没有则添加，否则直接返回

                //查询设备厂商编号 和设备型号编号是否存在
                TDeviceFactoryExample example = new TDeviceFactoryExample();
                example.createCriteria().andDeviceFactoryNumEqualTo(factoryNo);
                List<TDeviceFactory> tDeviceFactories = tDeviceFactoryMapper.selectByExample(example);
                if (tDeviceFactories != null && tDeviceFactories.size() == 1) {
                    factoryId = tDeviceFactories.get(0).getDeviceFactoryId();
                } else {
                    logger.warn("设备厂商编号不存在!");
                    throw new RuntimeException("设备厂商编号不存在!,编号：" + factoryNo);
                }

                TDeviceModelExample tmexample = new TDeviceModelExample();
                tmexample.createCriteria().andDeviceModelNumberEqualTo(modelNo);
                List<TDeviceModel> tDeviceModels = tDeviceModelMapper.selectByExample(tmexample);
                if (tDeviceModels != null && tDeviceModels.size() == 1) {
                    modelId = tDeviceModels.get(0).getDeviceModelId();
                } else {
                    logger.warn("设备型号不存在！");
                    throw new RuntimeException("设备型号不存在！,编号：" + modelNo);
                }

                // 组装好设备信息
                TDevice tDevice = new TDevice();
                tDevice.setCreationTime(new Date());
                tDevice.setDeviceNumber(deviceNo);
                tDevice.setProductionTime(productionTime);
                tDevice.setOrgId(Integer.valueOf(String.valueOf(orgId)));
                tDevice.setImei(iMei);
                tDevice.setDeviceType(1);
                tDevice.setDeviceFactoryId(factoryId);
                tDevice.setDeviceModelId(modelId);
                tDevice.setDeviceBrand(brand);
                tDevice.setDeviceStatus(0);//未激活
                tDevice.setDeviceBatch(batch);
                tDevice.setDeviceName(deviceName);
                deviceList.add(tDevice);
            }
        }
        // 注册设备iot 设备信息添加psk和deviceNumer
        deviceList = deviceManagerService.registerAll(deviceList);
        if (deviceList != null) {
            int count = tDeviceMapper.saveDeviceList(deviceList);// 保存设备信息
            if (count == deviceList.size()) {
                return true;
            }
            logger.error("注册设备，设备信息保存失败！");
        }
        throw new RuntimeException("设备导入失败！");
    }

    @Override
    public boolean modifyDeviceStatusByid(long deviceId, int status) {
        if (status < 0 || status > 2) {
            logger.info("设备状态参数错误！");
            return false;
        }
        TDevice record = new TDevice();
        record.setDeviceId(deviceId);
        record.setDeviceStatus(status);
        if(status == 1){
            this.deviceStarting(deviceId);
        }
        return tDeviceMapper.updateByPrimaryKeySelective(record) == 1;
    }

    @Override
    public boolean modifyByid(TDevice tDevice) {
        if (tDevice == null || tDevice.getDeviceId() == null) {
            return false;
        }
        return tDeviceMapper.updateByPrimaryKeySelective(tDevice) == 1;
    }

    @Override
    public List<TDevice> findDeviceByDogOwnerId(Long dogOwnerId) {
        return tDeviceMapper.findDeviceByDogOwnerId(dogOwnerId);
    }

    @Override
    public List<TDevice> findAll() {
        return tDeviceMapper.selectByExample(null);
    }

    @Override
    public DogRefDevice findDeviceByDogId(Long DogId) {
        DogRefDevice dogRefDevice = tDeviceMapper.findDeviceByDogId(DogId);
        return dogRefDevice;
    }

    @Override
    public Workbook generateExcel(List<DeviceRefModelInfo> deviceRefModelInfos) {
        String steetnNme = "设备信息表";
        String titleName = "设备信息表";
        String pattern = "yyyy年MM月dd日";
        String[] headers = {"序号", "设备名称", "设备编号", "设备imei号", "厂商编号", "产品型号", "批次信息", "品牌名称", "出厂日期"};
        List<ExportExcel> data = new ArrayList<>();
        for (int i = 0; i < deviceRefModelInfos.size(); i++) {
            DeviceRefModelInfo deviInfo = deviceRefModelInfos.get(i);
            ExportExcel excel = new ExportExcel();
            excel.setNo(i + 1);
            excel.setName(deviInfo.getDeviceName());
            excel.setImei(deviInfo.getImei());
            excel.setDeviceNo(deviInfo.getDeviceNumber());
            excel.setBrand(deviInfo.getDeviceBrand());
            excel.setBatch(deviInfo.getDeviceBatch());
            excel.setProductionTime(deviInfo.getProductionTime());

            if (deviInfo.gettDeviceFactory() != null) {
                excel.setFactoryNo(deviInfo.gettDeviceFactory().getDeviceFactoryNum());
            }
            if (deviInfo.gettDeviceModel() != null) {
                excel.setModelNo(deviInfo.gettDeviceModel().getDeviceModelNumber());
            }

            data.add(excel);
        }
        return ExcelUtile.javaBeanWriteWorkbook(steetnNme, titleName, headers, data, pattern);
    }

    @Override
    public TDeviceFactory saveAndFandDeviceFactoryByNum(String deviceFactoryNum) {
        if (StringUtils.isBlank(deviceFactoryNum)) {
            return null;
        }
        TDeviceFactory tDeviceFactorie = null;
        TDeviceFactoryExample example = new TDeviceFactoryExample();
        example.createCriteria().andDeviceFactoryNameEqualTo(deviceFactoryNum);
        List<TDeviceFactory> tDeviceFactories = tDeviceFactoryMapper.selectByExample(example);
        if (tDeviceFactories != null && tDeviceFactories.size() > 0) {
            tDeviceFactorie = tDeviceFactories.get(0);
        } else {//设备厂商信息不存在,新建一条厂商记录
            tDeviceFactorie = new TDeviceFactory();
            tDeviceFactorie.setCreationTime(new Date());
            tDeviceFactorie.setDeviceFactoryName(deviceFactoryNum);
            tDeviceFactorie.setDeviceFactoryName(deviceFactoryNum);
            Integer deviceFacotryId = tDeviceFactoryMapper.save(tDeviceFactorie);
            if (null == deviceFacotryId) {
                logger.info("厂商信息插入失败！");
                throw new RuntimeException();
            }
        }

        return tDeviceFactorie;
    }

    @Override
    public TDeviceModel saveAndFandDeviceModelByNum(String deviceModelNum) {
        if (StringUtils.isBlank(deviceModelNum)) {
            return null;
        }
        TDeviceModel tDeviceModel = null;
        TDeviceModelExample example = new TDeviceModelExample();
        example.createCriteria().andDeviceModelNameEqualTo(deviceModelNum);
        List<TDeviceModel> tDeviceModels = tDeviceModelMapper.selectByExample(example);
        if (tDeviceModels != null && tDeviceModels.size() > 0) {
            tDeviceModel = tDeviceModels.get(0);
        } else {
            tDeviceModel = new TDeviceModel();
            tDeviceModel.setCreationTime(new Date());
            tDeviceModel.setDeviceModelName(deviceModelNum);
            tDeviceModel.setDeviceModelNumber(deviceModelNum);
            Integer tDeviceModelId = tDeviceModelMapper.save(tDeviceModel);
            if (null == tDeviceModelId) {
                logger.info("厂商信息插入失败！");
                throw new RuntimeException();
            }
        }
        return tDeviceModel;
    }

    @Override
    public boolean modifyDeviceStatusByids(List<Long> deviceIds, Integer status) {
        if (deviceIds == null || deviceIds.size() <= 0 || status == null) {
            return false;
        }
        if (tDeviceModelMapper.modifyDeviceStatusByids(deviceIds, status) == deviceIds.size()) {
            return true;
        }
        if (status == 1) {
            //启用设备
            deviceIds.stream()
                    .forEach(x -> this.deviceStarting(x.longValue()));
        }

        logger.info("修改设备状态参数有误！");
        throw new RuntimeException();
    }

    /**
     * 启用设备
     *
     * @param deviceId
     */
    private boolean deviceStarting(long deviceId) {
        TDevice record = new TDevice();
        record.setDeviceId(deviceId);
        record.setStartTime(Calendar.getInstance().getTime());
        return 1 == tDeviceMapper.updateByPrimaryKey(record);
    }


    @Override
    public TDevice register(String imei, String deviceBrand, String deviceBatch) throws Exception {
        JSONObject result = deviceManagerService.register(imei, null, null, 0);
        if (result != null) {
            String deviceIdIot = result.getString("deviceId");
            String verifyCode = result.getString("verifyCode");
            String psk = result.getString("psk");

            TDevice tDevice = new TDevice();
            tDevice.setImei(imei);
            tDevice.setDeviceType(1);
            tDevice.setProductionTime(new Date());
            tDevice.setVerifyCode(verifyCode);
            tDevice.setPsk(psk);
            tDevice.setDeviceModelId(1);
            tDevice.setDeviceFactoryId(1);
            tDevice.setCreationTime(new Date());
            tDevice.setOrgId(1);
            tDevice.setDeviceIdIot(deviceIdIot);
            tDevice.setDeviceBatch(StringUtils.isNoneBlank(deviceBatch) ? deviceBatch : "无");
            tDevice.setDeviceBrand(StringUtils.isNotBlank(deviceBrand) ? deviceBrand : "无");
            tDevice.setDeviceRemarks("无");
            tDevice.setDeviceName(imei);
            tDevice.setDeviceNumber(imei);

            //TODO  实际不能要
            tDevice.setStartTime(new Date());
            tDevice.setDeviceStatus(1);//启用


            //插入设备并且修改设备信息
            if (deviceManagerService.modifyDeviceInfo(deviceIdIot, imei) && tDeviceMapper.insertSelective(tDevice) == 1) {
                return tDevice;
            }
            this.deleteDeviceByIotId(deviceIdIot);
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public boolean deleteDeviceByIotId(String deviceIdIot) {
        try {
            TDeviceExample example = new TDeviceExample();
            example.createCriteria().andDeviceIdIotEqualTo(deviceIdIot);
            if (1 == tDeviceMapper.deleteByExample(example)) {
                return deviceManagerService.deleteDevice(deviceIdIot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<DeviceRefOrg> findDevicesLikeDeviceNum(String keyWord, boolean isActive) {
        return tDeviceMapper.findDevicesLikeDeviceNum(keyWord, isActive);
    }

    @Override
    public List<Map<String, String>> findDatasByImei(String imei) {
        return tDeviceDataMapper.findDatasByImei(imei);
    }

    @Override
    public DeviceRefModelInfo findDeviceOtherInfoByid(long deviceId) {
        return tDeviceMapper.findDeviceOtherInfoByid(deviceId);
    }

}
