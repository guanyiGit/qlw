package com.soholy.dogmanager.service.reservation;

import java.util.List;
import java.util.Map;

import com.soholy.dogmanager.entity.TAppointment;
import com.soholy.dogmanager.entity.TDictionary;

public interface ReservationService {
    /**
     * @Description (根据用户id和医院名称查询预约列表)
     * @param userId
     * @param hospitalName 
     */
    List<ReserveInformation> findAppointmentsByUserIdAndLikeHospitalName(long userId, String hospitalName);


    /**
     * @Description (查询所有预约预约业务类型)
     * @return
     */
    List<TDictionary> findAppointmentBizAll();

    /**
     * @Description (新增预约)
     * @param tAppointment
     * @return
     */
    public boolean saveAppointment(TAppointment tAppointment);

    /**
     * @Description (查询机构预约业务)
     * @param orgId
     * @param keyWord 模糊匹配 电话和姓名
     * @return
     */
    List<ReserveInformation> findAppointmentsByOrgIdAndLikeUserInfo(Long orgId, String keyWord);

    /**
     * 
     * @Description (根据id删除记录)
     * @param appointmentId
     * @return
     */
    boolean removeByid(Long appointmentId);

    /**
     * 
     * @Description (查询所有预约业务类型)
     * @return
     */
    public List<Map<String, String>> findAppointmentChannelAll();

    /**
     * 
     * @Description (查询预约业务类型)
     * @return
     */
    List<TDictionary> findBizTypes();

    /**
     *  根据id修改预约信息
     * @param appointmentId 预约id
     * @param status 要修改的状态
     * @return
     */
    boolean modifyByid(Long appointmentId, Integer status);

    /**
     * 根据预约id修该预约信息
     * @param tAppointment
     * @return
     */
    boolean modefyById(TAppointment tAppointment);
}
