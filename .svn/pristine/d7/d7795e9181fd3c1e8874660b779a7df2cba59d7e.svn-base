package com.soholy.dogmanager.service.member.impl;

import com.soholy.dogmanager.entity.TMemberCard;
import com.soholy.dogmanager.entity.member.MemberInfo;
import com.soholy.dogmanager.mapper.TMemberCardMapper;
import com.soholy.dogmanager.service.member.MenberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class MenberServiceImpl implements MenberService {

    @Autowired
    private TMemberCardMapper tMemberCardMapper;

    /**
     * 生成会员证号码
     *
     * @return
     */
    public String getCradNo() {
        return CodeFactory.generateCode(3, true);
    }


    @Override
    public String addmenberCrad(TMemberCard tMemberCard) {
        tMemberCard.setCreationTime(new Date());
        tMemberCard.setIssueDate(new Date());
        tMemberCard.setMemberCardNo(getCradNo());
        return tMemberCardMapper.insertSelective(tMemberCard) == 1 ? tMemberCard.getMemberCardNo() : null;
    }

    @Override
    public List<MemberInfo> findMenberListByOrgId(Integer orgId, Long ownerId, String keyWord) {

        List<MemberInfo> memberList = tMemberCardMapper.findMenberListByOrgId(orgId, ownerId, keyWord);

        return memberList;
    }

    @Override
    public boolean modifyMemberCardInfo(TMemberCard tMemberCard) {
        return tMemberCardMapper.updateByPrimaryKeySelective(tMemberCard) == 1;
    }

    @Override
    public boolean removeByid(Long memberCardId) {
        return tMemberCardMapper.deleteByPrimaryKey(memberCardId) == 1;
    }

    @Override
    public MemberInfo findById(Long memberCardId) {
        return tMemberCardMapper.findById(memberCardId);
    }

}
