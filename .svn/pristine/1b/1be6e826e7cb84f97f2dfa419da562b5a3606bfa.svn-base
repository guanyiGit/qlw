package com.soholy.dogmanager.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TOrganizationExample;

public interface TOrganizationMapper {
    int countByExample(TOrganizationExample example);

    int deleteByExample(TOrganizationExample example);

    int insert(TOrganization record);

    

    List<TOrganization> selectByExample(TOrganizationExample example);

    TOrganization selectByPrimaryKey(Integer organizationId);

    int updateByExampleSelective(@Param("record") TOrganization record, @Param("example") TOrganizationExample example);

    int updateByExample(@Param("record") TOrganization record, @Param("example") TOrganizationExample example);

    int updateByPrimaryKeySelective(TOrganization record);

    int updateByPrimaryKey(TOrganization record);
    
    //添加机构
    int insertSelective(TOrganization organization);
    
    //跟新宠物医院申请状态==成功(orgtype = 1)
    int updateStatusForYes(@Param("organizationId")Integer organizationId,@Param("power")Integer power,@Param("approvalTime")Date approvalTime);
    
    //跟新宠物医院申请状态==失败(orgtype = 2)
    int updateStatusForNo(@Param("organizationId")Integer organizationId,@Param("failreason")String failreason,@Param("approvalTime")Date approvalTime);
    
    //删除宠物医院(orgtype = 2)
    int deleteServiceSiteById(Integer organizationId);
    
    //查询机构列表
    List<TOrganization> selectOrganizationList(@Param("orgType")Integer orgType,@Param("status")Integer status);

    //查询服务网点电话名称
    Map<String,String> selectPhone(@Param("orgId") Integer orgId);
    
}