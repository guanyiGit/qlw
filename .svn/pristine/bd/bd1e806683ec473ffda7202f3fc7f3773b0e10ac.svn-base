package com.soholy.dogmanager.mapper;

import java.util.List;

import com.soholy.dogmanager.entity.member.MemberInfo;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TMemberCard;
import com.soholy.dogmanager.entity.TMemberCardExample;

public interface TMemberCardMapper {
    int countByExample(TMemberCardExample example);

    int deleteByExample(TMemberCardExample example);

    int deleteByPrimaryKey(Long memberCardId);

    int insert(TMemberCard record);

    int insertSelective(TMemberCard record);

    List<TMemberCard> selectByExample(TMemberCardExample example);

    TMemberCard selectByPrimaryKey(Long memberCardId);

    TMemberCard selectTMemberCardByOwner(Long dogOwnerId);

    int updateByExampleSelective(@Param("record") TMemberCard record, @Param("example") TMemberCardExample example);

    int updateByExample(@Param("record") TMemberCard record, @Param("example") TMemberCardExample example);

    int updateByPrimaryKeySelective(TMemberCard record);

    int updateByPrimaryKey(TMemberCard record);

    /**
     *  查询犬只列表信息
     * @param orgId
     * @param ownerId
     * @param keyWord
     * @return
     */
    List<MemberInfo> findMenberListByOrgId(@Param("orgId") Integer orgId,
                                           @Param("ownerId") Long ownerId, @Param("keyWord")String keyWord);

    /**
     * 根据id查详情
     * @param memberCardId
     * @return
     */
    MemberInfo findById(Long memberCardId);
}