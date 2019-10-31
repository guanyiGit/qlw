package com.soholy.dogmanager.controller.violation;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TBanDogRefDict;
import com.soholy.dogmanager.service.violation.BanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 项目名称：dogmanager-web
 * 类名称：BlackListController
 * 类描述： 禁养犬种Controller
 * 创建人：YL
 * 创建时间：2018年8月27日 下午4:51:52
 * 修改人：Administrator
 * 修改时间：2018年8月27日 下午4:51:52
 * 修改备注：
 */
@Controller
@RequestMapping("/biz/ban")
public class BanController {

    @Autowired
    private BanService banService;


    /**
     * 新增
     *
     * @param banName
     * @param remrks
     * @return
     */
    @RequiresPermissions("/ban/save")
    @RequestMapping("/save")
    @ResponseBody
    public DogResult save(@RequestParam("banName") String banName, String remrks) {

        try {
            return banService.save(banName, remrks);
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "新增失败");
        }
    }

    //查列表
    @RequiresPermissions("/ban/findAll")
    @RequestMapping("/findAll")
    @ResponseBody
    public DogResult findAll(int pn, int pageSize, String string) {
        try {
            Page<TBanDogRefDict> TBlacklist = banService.findAll(pn, pageSize, string);
            return DogResult.ok(TBlacklist);
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "请求数据失败");
        }
    }

    //移除
    @RequiresPermissions("/ban/remove")
    @RequestMapping("/remove")
    @ResponseBody
    public DogResult removeBatch(@RequestParam("ids") List<Long> ids) {
        try {
            DogResult result = banService.removeBatch(ids);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "移除失败");
        }
    }

    /**
     * 检查是否已在黑名单列表
     *
     * @param name
     * @return false[在] true[不在]
     */
    @RequiresPermissions("/ban/checkd")
    @RequestMapping("/checkd")
    @ResponseBody
    public DogResult checkdIsBalck(String name) {
        return banService.checkBlackList(name) ? DogResult.ok(false) : DogResult.ok(true);
    }
}
