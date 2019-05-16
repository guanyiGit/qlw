package com.soholy.dogmanager.service.device;

import java.util.Date;

import com.soholy.dogmanager.common.iot.CmdType;
import com.soholy.dogmanager.entity.TDeviceCommand;
import com.soholy.dogmanager.entity.device.cmd.CmdmandRes;

public interface DeviceCommandService {

    /**
     * 
     * @Description (根据设备mid查询设备命令)
     * @param mid
     * @return
     */
    public abstract TDeviceCommand findDeviceCmdDataByMid(int mid);

    /**
     * @Description (根据设备imei更新设备命令结果信息)
     * @param mid 
     * @param resultCode [0失败 1成功]
     * @param imei
     * @param  rspTime 响应时间
     * @return
     */
    public abstract boolean modifyDeviceCmdByMidAndDeviceImei(int mid, int resultCode, String imei, Date rspTime);

    /**
     * @Description (保存设备命令)
     * @param deviceId 设备id
     * @param cmdType 命令类型
     * @param cmdValue 命令值
     * @param operatorId 用户id
     * @return
     * @throws Exception
     */
    boolean saveCommand(Long deviceId, CmdType cmdType, int cmdValue, long operatorId) throws Exception;

    /**
     * 
     * @Description (修改命令状态-根据命令iotid)
     * @param cmdmandRes
     */
    public abstract boolean modefyCommandStatusByIotCmdId(CmdmandRes cmdmandRes);
}
