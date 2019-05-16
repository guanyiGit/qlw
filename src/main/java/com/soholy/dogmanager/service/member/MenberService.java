package com.soholy.dogmanager.service.member;

import java.util.List;

import com.soholy.dogmanager.entity.TMemberCard;
import com.soholy.dogmanager.entity.member.MemberInfo;

public interface MenberService {

    /**
     * 
     * @Description (新增会员证)
     * @param tMemberCard
     * @return
     */
    String addmenberCrad(TMemberCard tMemberCard);

    /**
     * 
     * @Description (查询会员证)
     * @param orgId 机构id 可为空
     * @param ownerId 犬主id  可为空
     * @param keyWord
     * @return
     */
    List<MemberInfo> findMenberListByOrgId(Integer orgId, Long ownerId, String keyWord);

    /**
     * 
     * @Description (根据会员证id修改会员证信息)
     * @param tMemberCard
     * @return
     */
    boolean modifyMemberCardInfo(TMemberCard tMemberCard);

    /**
     * @Description (根据会员证id删除会员证信息)
     * @param memberCardId
     * @return
     */
    boolean removeByid(Long memberCardId);

    /**
     * 根据id查详情
     * @param memberCardId
     * @return
     */
    MemberInfo findById(Long memberCardId);
}
