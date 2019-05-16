package com.soholy.dogmanager.controller.dogCard;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.TableSplitResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.entity.dogCard.*;
import com.soholy.dogmanager.mapper.TDogOwnerMapper;
import com.soholy.dogmanager.pojo.dogCard.DogArchivesParm;
import com.soholy.dogmanager.service.dogCard.DogAndOwnerService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//查询犬和犬主相关信息
@Controller
@RequestMapping("/biz/dogAndOwner")
public class DogAndOwnerController {

    private static final Logger logger = Logger.getLogger(DogCardController.class);
    @Autowired
    DogAndOwnerService dogAndOwnerService;
    @Autowired
    TDogOwnerMapper tDogOwnerMapper;
    @Value("${SMS_BASE_URL}")
    private String sms_base_url;

    // 修改犬主信息
    //@RequiresPermissions("/dogAndOwner/updatetDogOwnerInfo")
    @RequestMapping("/updatetDogOwnerInfo")
    @ResponseBody
    public ResponseEntity<String> updatetDogOwnerInfo(@RequestBody User user, @RequestBody DogOwners dogOwners) {
        logger.debug("[犬证服务][修改犬主信息]：" + "user:" + user + " dogOwners:" + dogOwners);
        try {
            dogAndOwnerService.updatetDogOwnerInfo(user, dogOwners);
            logger.info("[犬证服务][修改犬主信息]：修改犬主信息成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000106", "修改犬主信息失败！");
        }
        return new ResponseEntity<String>("修改犬主信息成功！");
    }

    // 查询犬主档案里的犬主详情
    @RequiresPermissions("/dogAndOwner/selectDogOwnerAllInfo")
    @RequestMapping("/selectDogOwnerAllInfo")
    @ResponseBody
    public ResponseEntity<DogOwnerAllInfo> selectDogOwnerAllInfo(Long ownerId) {
        logger.debug("[犬证服务][查询犬主详情]：" + "ownerId:" + ownerId);
        DogOwnerAllInfo dogOwnerAllInfo = null;
        try {
            dogOwnerAllInfo = dogAndOwnerService.selectDogOwnerAllInfo(ownerId);
            logger.info("[犬证服务][查询犬主详情]：查询犬主详情成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000118", "查询犬主详情失败！");
        }
        return new ResponseEntity<DogOwnerAllInfo>(dogOwnerAllInfo);
    }

    // 查询犬主详情根据电话模糊匹配
    //@RequiresPermissions("/dogAndOwner/selectDogOwnersByPhone")
    @RequestMapping("/selectDogOwnersByPhone")
    @ResponseBody
    public String selectDogOwnersByPhone(String phone) {
        logger.debug("[犬证服务][查询犬主详情]：" + "phone:" + phone);
        List<DogOwners> dogOwners = null;
        try {
            dogOwners = dogAndOwnerService.selectDogOwnersByPhone(phone);
            logger.info("[犬证服务][查询犬主详情]：查询犬主详情成功！");
        } catch (Exception e) {
            logger.info("000130 查询犬主详情失败！");
            return new GlobalResult().failureJSON();
        }
        return new GlobalResult().successJSON(dogOwners);
    }
    // 查询犬主详情根据电话
    //@RequiresPermissions("/dogAndOwner/selectDogOwnersByPhoneee")
    @RequestMapping("/selectDogOwnersByPhoneee")
    @ResponseBody
    public String selectDogOwnersByPhoneee(String phone) {
        logger.debug("[犬证服务][查询犬主详情]：" + "phone:" + phone);
        List<DogOwners> dogOwners = null;
        try {
            dogOwners = dogAndOwnerService.selectDogOwnersByPhoneee(phone);
            logger.info("[犬证服务][查询犬主详情]：查询犬主详情成功！");
        } catch (Exception e) {
            logger.info("000130 查询犬主详情失败！");
            return new GlobalResult().failureJSON();
        }
        return new GlobalResult().successJSON(dogOwners);
    }

    // public String selectDogOwnerAllInfo(Long ownerId){
    // logger.debug("[犬证服务][查询犬主详情]："+"ownerId:"+ownerId);
    // DogOwnerAllInfo dogOwnerAllInfo = new DogOwnerAllInfo();
    // try {
    // dogOwnerAllInfo=dogAndOwnerService.selectDogOwnerAllInfo(ownerId);
    // logger.info("[犬证服务][查询犬主详情]：查询犬主详情成功！");
    // }catch (Exception e){
    // return "查询犬主详情失败！";
    // }
    // return "/static/views/dog/dogMasterFileDetail";
    // }
    //根据犬id查犬信息
    @RequestMapping("/selectDogInfoByDogId")
    @ResponseBody
    public ResponseEntity<DogInfo> selectDogInfoByDogId(Long dogId){
        DogInfo dogInfo = null;
        try {
            dogInfo=dogAndOwnerService.selectDogInfoByDogId(dogId);
        } catch (ServerException e) {
            return new ResponseEntity<>("000207", "根据犬id查询犬只信息失败！");
        }
        return new ResponseEntity<>(dogInfo);
    }
    // 根据用户id查询用户信息
    //@RequiresPermissions("/dogAndOwner/selectUserByUserId")
    @RequestMapping("/selectUserByUserId")
    @ResponseBody
    public ResponseEntity<User> selectUserByUserId(Long userId) {
        logger.debug("[犬证服务][根据用户id查询用户信息]：" + "userId:" + userId);
        User user = new User();
        try {
            user = dogAndOwnerService.selectUserByUserId(userId);
            logger.info("[犬证服务][根据用户id查询用户信息]：修改犬主信息成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000107", "根据用户id查询用户信息失败！");
        }
        return new ResponseEntity<User>(user);
    }

    // 修改犬信息
    //@RequiresPermissions("/dogAndOwner/updateDog")
    @RequestMapping("/updateDog")
    @ResponseBody
    public ResponseEntity<String> updateDog(@RequestBody DogInfo dogInfo) {
        logger.debug("[犬证服务][修改犬信息]：" + "dogInfo:" + dogInfo);
        try {
            dogAndOwnerService.updateDog(dogInfo);
            logger.info("[犬证服务][修改犬信息]：修改犬信息成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000108", "修改犬信息失败！");
        }
        return new ResponseEntity<String>("修改犬信息成功！");
    }

    // 查询我的宠物列表
    @RequiresPermissions("/dogAndOwner/selectMyDogs")
    @RequestMapping("/selectMyDogs")
    @ResponseBody
    public ResponseEntity<List<MyDog>> selectMyDogs(Long ownerId) {
        logger.debug("[犬证服务][查询我的宠物列表]：" + "ownerId:" + ownerId);
        List<MyDog> list = new ArrayList<>();
        try {
            list = dogAndOwnerService.selectMyDogs(ownerId);
            System.err.println(list);
            logger.info("[犬证服务][查询我的宠物列表]：查询我的宠物列表成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000109", "查询我的宠物列表失败！");
        }
        return new ResponseEntity<List<MyDog>>(list);
    }

    // 查询犬只档案列表或犬只注销列表
    @RequiresPermissions("/dogAndOwner/selectDogList")
    @RequestMapping("/selectDogList")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> selectDogList(@RequestBody DogArchivesParm dogArchivesParm) {
        logger.debug("[犬证服务][查询犬只档案列表]：" + "dogArchivesParm:" + dogArchivesParm);
        Map<String, Object> map = new HashMap<>();
        List<MyDog> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        try {
            list = dogAndOwnerService.selectDogList(dogArchivesParm);
            pageInfo = dogAndOwnerService.selectDogLiatCount(dogArchivesParm);
            map.put("dogInfos", list);
            map.put("page", pageInfo);
            logger.info("[犬证服务][查询犬只档案列表]：查询犬只档案列表成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000110", "查询犬只档案列表失败！");
        }
        return new ResponseEntity<Map<String, Object>>(map);
    }

    // 精准查询犬只档案列表或犬只注销列表
//    @RequiresPermissions("/dogAndOwner/selectDogListAccurate")
    @RequestMapping("/selectDogListAccurate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> selectDogListAccurate(@RequestBody DogArchivesParm dogArchivesParm) {
        logger.debug("[犬证服务][查询犬只档案列表]：" + "dogArchivesParm:" + dogArchivesParm);
        Map<String, Object> map = new HashMap<>();
        List<MyDog> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        try {
            list = dogAndOwnerService.selectDogListAccurate(dogArchivesParm);
            pageInfo = dogAndOwnerService.selectDogLiatCountAccurate(dogArchivesParm);
            map.put("dogInfos", list);
            map.put("page", pageInfo);
            logger.info("[犬证服务][查询犬只档案列表]：查询犬只档案列表成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000110", "查询犬只档案列表失败！");
        }
        return new ResponseEntity<Map<String, Object>>(map);
    }

    //查询有免疫证但没犬证的犬只信息
    @RequestMapping("/selectNoDogCard")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> selectNoDogCard(Integer num,Integer size,String input) {
        Map<String, Object> map = new HashMap<>();
        List<MyDog> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        try {
            list = dogAndOwnerService.selectNoDogCard(num,size,input);
            pageInfo = dogAndOwnerService.selectNoDogCardCont(num,size,input);
            map.put("dogInfos", list);
            map.put("page", pageInfo);
            logger.info("[犬证服务][查询犬只档案列表]：查询犬只档案列表成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000110", "查询犬只档案列表失败！");
        }
        return new ResponseEntity<Map<String, Object>>(map);
    }

    // 查询犬主档案列表
    @RequiresPermissions("/dogAndOwner/selectOwnerArchivesList")
    @RequestMapping("/selectOwnerArchivesList")
    @ResponseBody
    public TableSplitResult selectOwnerArchivesList(HttpServletRequest request, String input, Integer num, Integer size) {
        logger.debug("[犬证服务][查询犬主档案列表]：" + "input:" + input + " num:" + num + " size:" + size);
        if (StringUtil.isEmpty(input)) {
            input = null;
        }
        // Map<String,Object> map = new HashMap<>();
        List<DogOwners> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        TableSplitResult result = new TableSplitResult();
        try {
            if (StringUtil.isEmpty(input)) {
                input = null;
            } else {
//                input = new String(request.getParameter("input").getBytes("ISO-8859-1"), "UTF-8");
            }
            list = dogAndOwnerService.selectOwnerArchivesList(input, num, size);
            pageInfo = dogAndOwnerService.selectOwnerArchivesListCount(input, num, size);
            result.setPage(pageInfo.getPageNum());
            result.setTotal(pageInfo.getTotalCount());
            result.setRows(list);
            // map.put("dogInfos",list);
            // map.put("page",pageInfo);
            logger.info("[犬证服务][查询犬主档案列表]：查询犬主档案列表成功！");
        } catch (Exception e) {
            return new TableSplitResult();
        }
        return result;
    }

    // 查詢禁养犬种
//    @RequiresPermissions("/dogAndOwner/selectDogBanName")
    @RequestMapping("/selectDogBanName")
    @ResponseBody
    public ResponseEntity<String> selectBanDog(String dogName) {
        String dogNamee = null;
        try {
            dogNamee = dogAndOwnerService.selectBanDog(dogName);
        } catch (ServerException e) {
            return new ResponseEntity<>("000212", "查詢禁养犬种失败！");
        }
        return new ResponseEntity<String>(dogNamee);
    }

    // 插入禁养犬种
    @RequiresPermissions("/dogAndOwner/insertDogBan")
    @RequestMapping("/insertDogBan")
    @ResponseBody
    public ResponseEntity<Integer> insertDogBan(@RequestBody DogBan dogBan) {
        logger.debug("[犬证服务][插入禁养犬种]：" + "dogBan:" + dogBan);
        Integer id = null;
        try {
            id = dogAndOwnerService.insertDogBan(dogBan);
            logger.info("[犬证服务][插入禁养犬种]：插入禁养犬种成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000112", "插入禁养犬种失败！");
        }
        return new ResponseEntity<Integer>(id);
    }

    // 修改禁养犬种
    @RequiresPermissions("/dogAndOwner/updateDogBan")
    @RequestMapping("/updateDogBan")
    @ResponseBody
    public ResponseEntity<String> updateDogBan(@RequestBody DogBan dogBan) {
        logger.debug("[犬证服务][修改禁养犬种]：" + "dogBan:" + dogBan);
        try {
            dogAndOwnerService.updateDogBan(dogBan);
            logger.info("[犬证服务][修改禁养犬种]：修改禁养犬种成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000113", "修改禁养犬种失败！");
        }
        return new ResponseEntity<String>("修改禁养犬种成功！");
    }

    /**
     * 删除禁养犬种
     * @param id
     * @return
     */
    @RequestMapping(value = "/ban/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String remove(@PathVariable Integer id){
        return new GlobalResult().boolResultJSON(dogAndOwnerService.banRemoveByid(id));
    }

    // 查询禁养犬种详情
    //@RequiresPermissions("/dogAndOwner/selectDogBan")
    @RequestMapping("/selectDogBan")
    @ResponseBody
    public ResponseEntity<DogBan> selectDogBan(Long dogBreedId) {
        logger.debug("[犬证服务][查询禁养犬种详情]：" + "dogBreedId:" + dogBreedId);
        DogBan dogBan = new DogBan();
        try {
            dogBan = dogAndOwnerService.selectDogBan(dogBreedId);
            logger.info("[犬证服务][查询禁养犬种详情]：查询禁养犬种详情成功！");
        } catch (ServerException e) {
            return new ResponseEntity<>("000114", "查询禁养犬种详情失败！");
        }
        return new ResponseEntity<DogBan>(dogBan);
    }

    // 查询禁养犬种列表
    //@RequiresPermissions("/dogAndOwner/selectDogBanList")
    @RequestMapping("/selectDogBanList")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> selectDogBanList(HttpServletRequest request, Integer num, Integer size, String input) {
        logger.debug("[犬证服务][查询犬主档案列表]：" + " num:" + num + " size:" + size + " input:" + input);
        if (StringUtil.isEmpty(input)) {
            input = null;
        }
        Map<String, Object> map = new HashMap<>();
        List<DogBan> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        try {
            if (StringUtil.isEmpty(input)) {
                input = null;
            } else {
//                input = new String(request.getParameter("input").getBytes("ISO-8859-1"), "UTF-8");
            }
            list = dogAndOwnerService.selectDogBanList(num, size, input);
            pageInfo = dogAndOwnerService.selectDogBanListPage(num, size, input);
            map.put("dogInfos", list);
            map.put("page", pageInfo);
            logger.info("[犬证服务][查询禁养犬种列表]：查询禁养犬种列表成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000115", "查询禁养犬种列表失败！");
        }
        return new ResponseEntity<Map<String, Object>>(map);
    }

    // 首页查询禁养犬种列表
    @RequestMapping("/selectHomeDogBanList")
    @ResponseBody
    public Map<String, Object> selectHomeDogBanList(HttpServletRequest request, String input) {
        logger.debug("[犬证服务][查询犬主档案列表]：" + " input:" + input);
        Map<String, Object> map = new HashMap<>();
        List<DogBan> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        try {
            if (StringUtil.isEmpty(input)) {
                input = null;
            } else {
//                input = new String(request.getParameter("input").getBytes("ISO-8859-1"), "UTF-8");
            }
            list = dogAndOwnerService.selectDogBanListAll(input);
            pageInfo = dogAndOwnerService.selectDogBanListPage(1, null, input);
            map.put("page", pageInfo.getPageNum());
            map.put("records", pageInfo.getTotalCount());
            map.put("rows", list);
            logger.info("[犬证服务][查询禁养犬种列表]：查询禁养犬种列表成功！");
        } catch (Exception e) {
            return null;
        }
        return map;
    }

    // 注销犬
    @RequiresPermissions("/dogAndOwner/cancellationDog")
    @RequestMapping("/cancellationDog")
    @ResponseBody
    public ResponseEntity<String> cancellationDog(HttpServletRequest request, String cancellation, String cancellationNote, Long dogId) {// cancellation注销原因
        logger.debug("[犬证服务][注销犬]：" + "cancellation:" + cancellation + "dogId:" + dogId + "cancellationNote:" + cancellationNote);
        try {
            if (StringUtil.isEmpty(cancellation)) {
                cancellation = null;
            } else {
//                cancellation = new String(request.getParameter("cancellation").getBytes("ISO-8859-1"), "UTF-8");
            }
            if (StringUtil.isEmpty(cancellationNote)) {
                cancellationNote = null;
            } else {
//                cancellationNote = new String(request.getParameter("cancellationNote").getBytes("ISO-8859-1"), "UTF-8");
            }
            dogAndOwnerService.cancellationDog(cancellation, cancellationNote, dogId);
            logger.info("[犬证服务][注销犬]：注销犬成功！");
        } catch (Exception e) {
            return new ResponseEntity<>("000116", "注销犬失败！");
        }
        return new ResponseEntity<String>("注销犬成功！");
    }

    /**
     * @param
     * @param
     * @return
     * @Description (查询注销原因)
     */
    //@RequiresPermissions("/dogAndOwner/logouts")
    @RequestMapping("/logouts")
    @ResponseBody
    public String logouts() {
        return new GlobalResult().successJSON(dogAndOwnerService.FindlogoutReasons());
    }


    // 根据犬主姓名或电话查询犬主列表
//  @RequiresPermissions("/dogAndOwner/selectDogOwners")
    @RequestMapping("/selectDogOwners")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> selectDogOwners(@RequestBody ListParams listParams) {
        Map<String, Object> map = new HashMap<>();
        List<DogOwners> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        try {
            list = dogAndOwnerService.queryDogOwners(listParams);
            pageInfo = dogAndOwnerService.queryDogOwnersCount(listParams);
            map.put("owners", list);
            map.put("page", pageInfo);
        } catch (ServerException e) {
            return new ResponseEntity<>("000222", "查询犬主列表失败！");
        }
        return new ResponseEntity<Map<String, Object>>(map);
    }

    // 根据犬主id分页查询我的犬只列表
//  @RequiresPermissions("/dogAndOwner/selectMyDogs")
    @RequestMapping("/selectMyDogsPag")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> selectMyDogsPag(@RequestBody ListParams listParams) {
        Map<String, Object> map = new HashMap<>();
        List<MyDog> list = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        try {
            list = dogAndOwnerService.selectMyDogsPag(listParams);
            pageInfo = dogAndOwnerService.selectMyDogsPagCount(listParams);
            map.put("myDogs", list);
            map.put("page", pageInfo);
        } catch (ServerException e) {
            return new ResponseEntity<>("000222", "查询我的宠物列表失败！");
        }
        return new ResponseEntity<Map<String, Object>>(map);
    }

    //根据免疫证号查免疫证号
    @RequestMapping("/selectIminNumBymin")
    @ResponseBody
    public String selectIminNumBymin(String min){
        String minn = null;
        try {
            minn = tDogOwnerMapper.selectIminNumBymin(min);
        } catch (Exception e) {
            return "查询失败";
        }
        return minn;
    }

    //爱心领养发送验证码
    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(String phone){
        String code = null;
        try {
            Map<String, String> params = new HashMap<>();
            params.put("phone", phone);
            params.put("type",Integer.toString(12));
            try {
                HttpResult  httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
                String content = httpResult.getContent();
                System.out.println(content);
//                JsonUtils.jsonToPojo()
                JSONObject jsonObject = JSONObject.parseObject(content);
                JSONObject data = JSONObject.parseObject(jsonObject.get("data").toString());
                code = (String) data.get("code");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            return null;
        }
        return code;
    }
}
