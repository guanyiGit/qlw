package com.soholy.dogmanager.controller.fence;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.soholy.dogmanager.common.result.GlobalResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TFence;
import com.soholy.dogmanager.entity.TFenceCoordinate;
import com.soholy.dogmanager.pojo.fence.FenceRefCoordinate;
import com.soholy.dogmanager.service.fence.FenceService;

@Controller
@RequestMapping("/biz/fence")
public class FenceController {

    @Autowired
    private FenceService fenceService;

    /**
     * 添加围栏
     */
    @RequiresPermissions("/fence/addFence")
    @RequestMapping(value = "/addFence", method = RequestMethod.POST)
    @ResponseBody
    public DogResult addFence(String fence, String coordinates) {
        TFence fences = JSON.parseObject(fence, TFence.class);
        List<TFenceCoordinate> coordinatesList = JSON.parseArray(coordinates, TFenceCoordinate.class);
        return fenceService.addFence(fences, coordinatesList, null);
    }


    /**
     * 添加围栏
     */
    @RequiresPermissions("/fence/addFence")
    @RequestMapping(value = "/addFences", method = RequestMethod.POST)
    @ResponseBody
    public String addFences(@RequestBody List<FenceRefCoordinate> fenceRefCoordinate) {
        GlobalResult result = new GlobalResult();
        if (fenceRefCoordinate == null || fenceRefCoordinate.size() == 0) {
            return result.failureJSON("参数有误");
        }
        List<Object> collect = fenceRefCoordinate.stream()
                .map(x -> {
                    TFence fence = new TFence();
                    fence.setCreationTime(new Date());
                    fence.setFenceName(x.getFenceName());
                    fence.setFenceType(x.getFenceType());
                    fence.setOperatorId(x.getOperatorId());
                    fence.setStartTime(x.getStartTime());
                    fence.setStatus(x.getStatus());
                    List<TFenceCoordinate> coordinates = x.getCoordinates();
                    DogResult dogResult = fenceService.addFence(fence, coordinates,x.getNewFenceId());
                    if(dogResult.getStatus() == 200){
                        return dogResult.getData();
                    }
                    return dogResult.getStatus() == 200 ? dogResult.getData() : null;
                }).filter(x->x!=null)
                .collect(Collectors.toList());

        return result.objResultJSON(collect);
    }


    /**
     * 删除
     */
    @RequiresPermissions("/fence/deleteFence")
    @RequestMapping(value = "/deleteFence", method = RequestMethod.POST)
    @ResponseBody
    public DogResult deleteFence(Long fenceId) {
        return fenceService.deleteFenceById(fenceId);
    }


    /**
     * 查询围栏
     */
    @RequiresPermissions("/fence/selectFence")
    @RequestMapping(value = "/selectFence", method = RequestMethod.POST)
    @ResponseBody
    public DogResult selectFence(Long operatorId) {
        try {
            List<TFence> fences = null;
            if (operatorId == null) {
                fences = fenceService.selectFences();
            } else {
                fences = fenceService.selectFences(operatorId);
            }
            return DogResult.ok(fences);

        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param operatorId 设定人id(可不传)
     * @param fenceId (可不传)
     * @Description:获取围栏详情
     * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/fence/selectFenceRefCoordinate")请教
    @RequestMapping(value = "/selectFenceRefCoordinate", method = RequestMethod.POST)
    @ResponseBody
    public DogResult selectFenceRefCoordinate(Long operatorId,Long fenceId) {
        try {
            List<FenceRefCoordinate> refCoordinates = fenceService.selectFenceRefCoordinate(operatorId,fenceId);
            return DogResult.ok(refCoordinates);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 修改围栏信息
     *
     * @param fenceId
     * @param tFenceCoordinates
     */
    @RequestMapping(value = "/modify/{fenceId}", method = RequestMethod.POST)
    public DogResult modefy(@PathVariable long fenceId, @RequestBody List<TFenceCoordinate> tFenceCoordinates) {
        boolean bool = fenceService.modifyById(fenceId, tFenceCoordinates);
        return bool ? DogResult.ok() : DogResult.build(400, "修改失败");
    }

    /**
     * 查询围栏详细
     * @param fenceIds
     * @return
     */
    @RequestMapping(value = "/fenceIds",method = RequestMethod.GET)
    @ResponseBody
    public String findDetails(long[] fenceIds) {
        return new GlobalResult().objResultJSON(fenceService.findDetailByids(fenceIds));
    }

}
