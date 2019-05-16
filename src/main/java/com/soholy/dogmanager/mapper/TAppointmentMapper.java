package com.soholy.dogmanager.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TAppointment;
import com.soholy.dogmanager.entity.TAppointmentExample;
import com.soholy.dogmanager.service.reservation.ReserveInformation;

public interface TAppointmentMapper {

    int countByExample(TAppointmentExample example);

    int deleteByExample(TAppointmentExample example);

    int deleteByPrimaryKey(Long appointmentId);

    int insert(TAppointment record);

    int insertSelective(TAppointment record);

    List<TAppointment> selectByExampleWithBLOBs(TAppointmentExample example);

    List<TAppointment> selectByExample(TAppointmentExample example);

    TAppointment selectByPrimaryKey(Long appointmentId);

    int updateByExampleSelective(@Param("record") TAppointment record, @Param("example") TAppointmentExample example);

    int updateByExampleWithBLOBs(@Param("record") TAppointment record, @Param("example") TAppointmentExample example);

    int updateByExample(@Param("record") TAppointment record, @Param("example") TAppointmentExample example);

    int updateByPrimaryKeySelective(TAppointment record);

    int updateByPrimaryKeyWithBLOBs(TAppointment record);

    int updateByPrimaryKey(TAppointment record);

    /**
     * @Description (根据用户id和医院名称查询预约列表)
     * @param userId
     * @param hospitalName 网点名称
     */
    List<ReserveInformation> findAppointmentsByUserIdAndLikeHospitalName(@Param("userId") long userId,
            @Param("hospitalName") String hospitalName);

    /**
     * @Description (检查通知即将到期的)
     * @param day 提前的天数
     * @param curTime 检查开始的时间
     * @return
     */
    List<ReserveInformation> findAppointmentIsExpire(@Param("day") int day, @Param("curTime") Date curTime);

    /**
     * @Description (查询机构预约业务)
     * @param orgId
     * @param keyWord 模糊匹配 电话和姓名
     * @return
     */
    List<ReserveInformation> findAppointmentsByOrgIdAndLikeUserInfo(@Param("orgId") Long orgId,
            @Param("keyWord") String keyWord);

    /**
     * @Description (查询所有预约业务类型)
     * @return dicName,decType
     */
    List<Map<String, String>> findAppointmentChannelAll();

    String selectOrgName(@Param("orgId") Long orgId);
}
