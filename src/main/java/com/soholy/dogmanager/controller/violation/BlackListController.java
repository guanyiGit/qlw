package com.soholy.dogmanager.controller.violation;

import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.common.utils.JsonUtils;
import com.soholy.dogmanager.entity.TBlacklist;
import com.soholy.dogmanager.service.violation.BlankService;
import com.soholy.dogmanager.utils.GetClientIpAddress;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 项目名称：dogmanager-web
 * 类名称：BlackListController
 * 类描述： 黑名单Controller
 * 创建人：YL
 * 创建时间：2018年8月27日 下午4:51:52
 * 修改人：Administrator
 * 修改时间：2018年8月27日 下午4:51:52
 * 修改备注：
 *
 */
@Controller
@RequestMapping("/biz/balck")
public class BlackListController {

    @Autowired
    private BlankService blankService;
    @Value("${SMS_BASE_URL}")
    private String SMS_BASE_URL;

    //新增
    @RequiresPermissions("/balck/save")
    @RequestMapping("/save")
    @ResponseBody
    public DogResult saveBlack(@RequestBody TBlacklist tBlacklist){
        try {
            DogResult result = blankService.save(tBlacklist);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "新增失败");
        }
    }

    //查列表
    @RequiresPermissions("/balck/findAll")
    @RequestMapping("/findAll")
    @ResponseBody
    public DogResult findAll(int pn,int pageSize,String string){
        try {
            if(!StringUtils.isEmpty(string)){
//                string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
            }
            Page<TBlacklist> TBlacklist = blankService.findAll(pn, pageSize, string);
            return DogResult.ok(TBlacklist);
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "请求数据失败");
        }
    }

    //查详情
    @RequiresPermissions("/balck/findOne")
    @RequestMapping("/findOne")
    @ResponseBody
    public DogResult findOne(Long blackId){
        try {
            TBlacklist blacklist = blankService.findOne(blackId);
            return DogResult.ok(blacklist);
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "请求数据失败");
        }
    }

    //移除
    @RequiresPermissions("/balck/remove")
    @RequestMapping("/remove")
    @ResponseBody
    public DogResult removeBatch(Long[] blackIdList){
        try {
            DogResult result = blankService.removeBatch(Arrays.asList(blackIdList));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "移除失败");
        }
    }

    //黑名单短信
    @RequestMapping("/sendMessage")
    @ResponseBody
    public DogResult sendMessage(String phone,HttpServletRequest request){
        String url=SMS_BASE_URL+"BlacklistSMS";
        String ipAddress = GetClientIpAddress.getClientIpAddress(request);
        Map<String, Object> template_param = new HashMap<String, Object>();
        Map<String, Object> Map = new HashMap<>();
        Map.put("phone", phone);
        Map.put("ipAddress", ipAddress);
        Map.put("template_param", JsonUtils.objectToJson(template_param));
        try {
            HttpClientUtil.executeHttpParams(url, "post", Map);
            return DogResult.ok();
        } catch (Exception e) {
            // TODO: handle exception
            return DogResult.build(400, "发送失败");
        }
    }


    //根据姓名或身份证或电话检查黑名单是否存在
    @RequestMapping("/check")
    @ResponseBody
    public DogResult checkBlackList(String string){
        TBlacklist list = blankService.checkBlackList(string);
        if(org.springframework.util.StringUtils.isEmpty(list)){
            return DogResult.ok(true);
        }
        return  DogResult.ok(false);
    }

}
