package com.soholy.dogmanager.controller.serviceSite;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TPetHospital;
import com.soholy.dogmanager.pojo.servicesite.ServiceSite;
import com.soholy.dogmanager.pojo.servicesite.ServiceSiteCard;
import com.soholy.dogmanager.pojo.servicesite.ServiceSiteObj;
import com.soholy.dogmanager.service.servicesite.ServiceSiteService;
import com.soholy.dogmanager.service.servicesite.SiteCardService;
import com.soholy.dogmanager.utils.Point;
import com.soholy.dogmanager.utils.fence.AddressResolution;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/biz/serviceSite")
public class ServiceSiteController {

    @Autowired
    private ServiceSiteService serviceSiteService;

    @Value("${GDKey}")
    private String key;

    @Value("${pageSize}")
    private String pageSize;

    @Autowired
    private SiteCardService siteCardService;

    /**
     * @param serviceSiteObj
     * @Description:添加服务网点（宠物医院）
     * @return（展示方法参数和返回值）
     */
    // @RequiresPermissions("/serviceSite/add")游客首页不需要权限控制
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public DogResult addServiceSite(@RequestBody ServiceSiteObj serviceSiteObj) {
        try {
            TOrganization organization = new TOrganization();

            // 将organization json字符串转化为TOrganization对象
            PropertyUtils.copyProperties(organization, serviceSiteObj);
            List<TPetHospital> petHospitalList = serviceSiteObj.getPetHospitals();
            DogResult addServiceSite = serviceSiteService.addServiceSite(organization, petHospitalList);
            return addServiceSite;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param serviceSiteObj
     * @Description:添加服务网点（宠物医院）
     * @return（展示方法参数和返回值）
     */
    // @RequiresPermissions("/serviceSite/add")游客首页不需要权限控制
    @SuppressWarnings("all")
    @RequestMapping(value = "/add1", method = RequestMethod.POST)
    @ResponseBody
    public DogResult addServiceSite1(@RequestBody ServiceSiteObj serviceSiteObj) {
        try {
            TOrganization organization = new TOrganization();
            // 将organization json字符串转化为TOrganization对象
            PropertyUtils.copyProperties(organization, serviceSiteObj);
            List<TPetHospital> petHospitalList = serviceSiteObj.getPetHospitals();
            DogResult addServiceSite = serviceSiteService.addServiceSite1(organization, petHospitalList);
            return addServiceSite;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 查询医院证书id和类型
     *
     * @param organizationId
     * @return
     */
    @RequestMapping(value = "/selectPetHCardIds")
    @ResponseBody
    public DogResult selectPetHCardIds(Integer organizationId) {
        try {
            List<TPetHospital> list = siteCardService.selectPetHCardIds(organizationId);
            return DogResult.ok(list);
        } catch (ServerException e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 地址转坐标
     *
     * @param addressName 地址详细信息
     * @return
     */
    @RequestMapping(value = "/searchPosition", method = RequestMethod.GET)
    @ResponseBody
    public String searchPosition(@RequestParam("addressName") String addressName) {
        Map<String, String> addressMap = AddressResolution.AddressToResolution(addressName, null, "97580a2aac84a3c383abdf17352c24ac");
        if (addressMap != null && addressMap.size() > 0) {
            Point point = new Point();
            point.setLongitude(Double.valueOf(addressMap.get("longitude")));
            point.setLatitude(Double.valueOf(addressMap.get("latitude")));
            return new GlobalResult().objResultJSON(point);
        }
        return new GlobalResult().boolResultJSON(false);
    }

    /**
     * @param organizationId
     * @param status
     * @param failReason
     * @Description:更新服务网点申请状态
     * @return（展示方法参数和返回值）
     */
    @RequiresPermissions("/serviceSite/update") // 添加权限控制
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public DogResult updateServiceSite(Integer organizationId, Integer status, String failReason, Integer power) {
        try {

            if (status == 1) {
                Date approvalTime = new Date();
                DogResult result = serviceSiteService.updateServiceSiteForYes(organizationId, power, approvalTime);
                return result;
            } else {
                Date approvalTime = new Date();
                DogResult result = serviceSiteService.updateServiceSiteForNo(organizationId, failReason, approvalTime);
                return result;
            }
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param organizationId
     * @Description:删除服务网点
     * @return（展示方法参数和返回值）
     */
    // @RequiresPermissions("/serviceSite/delete") // 添加权限控制
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public DogResult deleteServiceSite(Integer organizationId) {
        try {
            DogResult result = serviceSiteService.deleteServiceSite(organizationId);
            return result;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param provinceId  省id
     * @param ownedCityId 市id
     * @param districtId  区id
     * @param orgtype     机构类型(默认宠物医院<2>)
     * @param pageNum
     * @param pageSize
     * @param power       宠物医院办证权限
     * @return（展示方法参数和返回值）
     * @Description:查询服务机构(适用于犬主用户)
     */
    // @RequiresPermissions("/serviceSite/getServiceSites")
    @RequestMapping(value = "/getServiceSites", method = RequestMethod.POST)
    @ResponseBody
    public DogResult getServiceSite(Integer provinceId, Integer ownedCityId, Integer districtId, Integer orgtype,
                                    Integer pageNum, Integer pageSize, Integer power, Double lat, Double lng) {
        try {
            if (pageNum == null) {
                pageNum = 1;
            }
            if (pageSize == null) {
                pageSize = Integer.parseInt(this.pageSize);
            }
            if (orgtype == null) {
                orgtype = 2;
            }
            Page page = null;
            if (pageNum != null && pageSize != null) {
                page = PageHelper.startPage(pageNum, pageSize);
            }
            // 默认查询已审核成功的服务网点
            List<ServiceSite> serviceSites = serviceSiteService.selectServiceSite(provinceId, ownedCityId, districtId,
                    orgtype, pageNum, pageSize, lng, lat, 1, power, null,null);
            return DogResult.ok(serviceSites);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    @RequestMapping(value = "/getServiceSitesPage", method = RequestMethod.POST)
    @ResponseBody
    public DogResult getServiceSitePage(Integer provinceId, Integer ownedCityId, Integer districtId, Integer orgtype,
                                        Integer pageNum, Integer pageSize, Integer power, Double lat, Double lng) {
        try {
            if (pageNum == null) {
                pageNum = 1;
            }
            if (pageSize == null) {
                pageSize = Integer.parseInt(this.pageSize);
            }
            if (orgtype == null) {
                orgtype = 2;
            }
            if (pageNum != null && pageSize != null) {
                PageHelper.startPage(pageNum, pageSize);
            }

            List<ServiceSite> serviceSites = serviceSiteService.selectServiceSite(provinceId, ownedCityId, districtId,
                    orgtype, pageNum, pageSize, lng, lat, 1, power, null,null);

            return DogResult.ok(new PageInfo<ServiceSite>(serviceSites));
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param provinceId
     * @param ownedCityId
     * @param districtId
     * @param orgtype     机构类型
     * @param status      状态(0.待审核 1.审核通过 2.审核不通过)
     * @param pageNum
     * @param pageSize
     * @param power       办证权限 0免疫证 1(免疫证,犬证) @return（展示方法参数和返回值）
     * @param searchKey   搜索关键字
     * @Description:查询服务网点(适用于运营方管理员)
     */
//    @RequiresPermissions("/serviceSite/getServiceSitesforAdmin")
    @RequestMapping(value = "/getServiceSitesforAdmin", method = RequestMethod.POST)
    @ResponseBody
    public DogResult getServiceSitesforAdmin(Integer provinceId, Integer ownedCityId, Integer districtId,
                                             Integer orgtype, Integer status, Integer pageNum, Integer pageSize, Integer power, String searchKey,Integer tType) {
        try {
            if (pageNum == null) {
                pageNum = 1;
            }
            if (pageSize == null) {
                pageSize = Integer.parseInt(this.pageSize);
            }
            Page page = null;
            if (pageNum != null && pageSize != null) {
                page = PageHelper.startPage(pageNum, pageSize);
            }
            List<ServiceSite> serviceSites = serviceSiteService.selectServiceSite(provinceId, ownedCityId, districtId,
                    orgtype, pageNum, pageSize, null, null, status, power, searchKey,tType);
            PageInfo<ServiceSite> pageInfo = new PageInfo<>(serviceSites);
            pageInfo.setTotal(page.getTotal());
            return DogResult.ok(pageInfo);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param provinceId
     * @param ownedCityId
     * @param districtId
     * @param orgtype
     * @param page
     * @param rows
     * @param ALon
     * @param ALat
     * @Description:查询附近服务网点(分页)
     * @return（展示方法参数和返回值）
     */
    // @RequiresPermissions("/serviceSite/findServiceSites") // 添加权限控制(待确认)
    @RequestMapping(value = "/findServiceSites", method = RequestMethod.POST)
    @ResponseBody
    public DogResult getServiceSites(Integer provinceId, Integer ownedCityId, Integer districtId, Integer orgtype,
                                     Integer pageNum, Integer pageSize, Double ALon, Double ALat, Integer power) {
        try {
            if (pageNum == null) {
                pageNum = 1;
            }
            if (pageSize == null) {
                pageSize = Integer.parseInt(this.pageSize);
            }
            List<ServiceSite> serviceSites = serviceSiteService.selectServiceSite(provinceId, ownedCityId, districtId,
                    orgtype, pageNum, pageSize, ALon, ALat, 1, power, null,null);
            return DogResult.ok(serviceSites);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    // 查询附近服务网点小程序端

    /**
     * @param ALon
     * @param ALat
     * @Description:查询附近服务网点(不分页)
     * @return（展示方法参数和返回值）
     */
    // @RequiresPermissions("/serviceSite/getNearbyServiceSites")
    @RequestMapping(value = "/getNearbyServiceSites", method = RequestMethod.POST)
    @ResponseBody
    public DogResult getNearbyServiceSite(double ALon, double ALat) {
        try {
            List<ServiceSite> serviceSites = serviceSiteService.SelectNearServiceSite(ALon, ALat);
            return DogResult.ok(serviceSites);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 查看服务网点详情
     *
     * @param organizationId
     * @return
     */
    @RequestMapping(value = "/getServiceSite")
    @ResponseBody
    public DogResult getServiceSite(Integer organizationId) {
        try {
            ServiceSite serviceSite = serviceSiteService.selectServiceSite(organizationId);
            return DogResult.ok(serviceSite);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    // @RequiresPermissions("/serviceSite/selectSiteCard")
    @RequestMapping(value = "/selectSiteCard", method = RequestMethod.POST)
    @ResponseBody
    public DogResult selectSiteCard(Integer organizationId) {
        try {
            List<ServiceSiteCard> serviceSiteCards = siteCardService.selectSiteCard(organizationId);
            return DogResult.ok(serviceSiteCards);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    // @RequiresPermissions("/serviceSite/addSiteCard")
    @RequestMapping(value = "/addSiteCard", method = RequestMethod.POST)
    @ResponseBody
    public DogResult addSiteCard(TPetHospital petHospital) {
        try {
            DogResult addSiteCard = siteCardService.addSiteCard(petHospital);
            return addSiteCard;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    @RequestMapping(value = "/selectOrgByTypeId", method = RequestMethod.POST)
    @ResponseBody
    public DogResult selectOrgByTypeId(Integer orgType) {
        try {
            List<TOrganization> organizationList = serviceSiteService.selectOrganizationList(orgType);
            System.out.println(JSONObject.toJSONString(organizationList));
            return DogResult.ok(organizationList);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 修改服务网点信息
     * @param site
     * @return
     */
    @RequestMapping(value = "/updateSite", method = RequestMethod.POST)
    @ResponseBody
    public DogResult updateSite(@RequestBody  ServiceSite site) {
        try {
            int a= serviceSiteService.updateSite(site);
            return DogResult.ok(a);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

}
