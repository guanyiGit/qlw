package com.soholy.dogmanager.controller.member;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.entity.TMemberCard;
import com.soholy.dogmanager.entity.member.MemberInfo;
import com.soholy.dogmanager.service.member.MenberService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/biz/member")
public class MemberController {

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MenberService menberService;

    /**
     * @param tMemberCard
     * @return
     * @Description (新增会员证)
     */
    @RequiresPermissions("/member/add")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(TMemberCard tMemberCard) {
        if (tMemberCard != null) {
            return new GlobalResult().objResultJSON(menberService.addmenberCrad(tMemberCard));
        }
        logger.info("新增会员证信息参数有误！");
        return new GlobalResult().failureJSON();
    }

    /**
     * 根据id查详情
     *
     * @param memberCardId
     * @return
     */
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public String findOne(@RequestParam("memberCardId") Long memberCardId) {
        return new GlobalResult().objResultJSON(menberService.findById(memberCardId));
    }

    /**
     * @param offset
     * @param limit
     * @param keyWord 会员证号，犬主姓名/电话
     * @return
     * @Description (查询会员证)
     */
    @RequiresPermissions("/member/list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Integer orgId,
                       Long ownerId,
                       @Param("offset") Integer offset, @Param("limit") Integer limit,
                       String keyWord) {

//        PageHelper.offsetPage(offset, limit);
        PageHelper.startPage(offset, limit);

        List<MemberInfo> crads = menberService.findMenberListByOrgId(orgId, ownerId, keyWord);

        PageInfo<MemberInfo> resultPagees = new PageInfo<>(crads);
        return new GlobalResult().successJSON(resultPagees);
    }

    /**
     * @param tMemberCard 会员证信息不能为空
     * @return
     * @Description (修改会员证信息)
     */
    @RequiresPermissions("/member/update")
    @RequestMapping(method = RequestMethod.PUT)
    public String modify(TMemberCard tMemberCard) {
        if (tMemberCard != null && tMemberCard.getMemberCardId() != null) {
            boolean bool = menberService.modifyMemberCardInfo(tMemberCard);

            return new GlobalResult().boolResultJSON(bool);
        }
        logger.info("修改会员证信息参数有误！");
        return new GlobalResult().failureJSON();
    }

    /**
     * @return
     * @Description (删除会员证信息 根据证件id)
     */
    @RequiresPermissions("/member/delete")
    @RequestMapping(value = "/{memberCardId}", method = RequestMethod.DELETE)
    public String modify(@PathVariable(value = "memberCardId") Long memberCardId) {
        boolean bool = menberService.removeByid(memberCardId);
        return new GlobalResult().boolResultJSON(bool);
    }

}
