package com.soholy.dogmanager.service.servicesite.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.utils.MathUtils;
import com.soholy.dogmanager.common.utils.Md5Encode;
import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TPetHospital;
import com.soholy.dogmanager.entity.TUserRefRoles;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.mapper.TOrganizationMapper;
import com.soholy.dogmanager.mapper.TPetHospitalMapper;
import com.soholy.dogmanager.mapper.TUserRefRolesMapper;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.mapper.serviceSite.ServiceSiteMapper;
import com.soholy.dogmanager.mapper.serviceSite.TypeRefImagesMapper;
import com.soholy.dogmanager.pojo.servicesite.ServiceSite;
import com.soholy.dogmanager.pojo.servicesite.TypeRefImages;
import com.soholy.dogmanager.pojo.user.UserVo;
import com.soholy.dogmanager.service.servicesite.ServiceSiteService;
import com.soholy.dogmanager.service.servicesite.SiteCardService;
import com.soholy.dogmanager.service.user.UserService;
import com.soholy.dogmanager.utils.fence.FenceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class ServiceSiteServiceImpl implements ServiceSiteService {

    private static Logger logger = LoggerFactory.getLogger(ServiceSiteServiceImpl.class);

    @Autowired
    private TOrganizationMapper organizationMapper;

    @Autowired
    private ServiceSiteMapper serviceSiteMapper;

    @Autowired
    private TypeRefImagesMapper typeRefImagesMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private TUsersMapper userMapper;

    @Autowired
    private TUserRefRolesMapper userRefRolesMapper;

    @Autowired
    private TPetHospitalMapper petHospitalMapper;


    @Value("${ServiceSite_radius}")
    private String ServiceSite_radius;

    @Autowired
    private SiteCardService siteCardService;

    @Value("${SMS_BASE_URL}")
    private String sms_base_url;


    @Override
    public DogResult addServiceSite(TOrganization organization, List<TPetHospital> petHospitals) throws Exception {
        // 完善TOrganization信息
        // 默认申请时间为当前系统时间
        organization.setCreationTime(new Date());
        try {
            organizationMapper.insertSelective(organization);
            for (TPetHospital tPetHospital : petHospitals) {
                tPetHospital.setOrganizationId(organization.getOrganizationId());
                tPetHospital.setCreationTime(new Date());
                petHospitalMapper.insertSelective(tPetHospital);
            }
            return DogResult.ok(organization.getOrganizationId());
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后再试");
        }
    }

    @SuppressWarnings("all")
    @Override
    public DogResult addServiceSite1(TOrganization organization, List<TPetHospital> petHospitals) throws Exception {
        // 完善TOrganization信息
        //判断username是否可用
        DogResult dogResult = userService.checkUserName(organization.getUsername());
        if (!(Boolean) dogResult.getData()) {
            return DogResult.build(401, "账号已被注册，请重新输入");
        }
        organization.setPassword(Md5Encode.getCredentials(organization.getUsername(), organization.getPassword()).toString());
        // 默认申请时间为当前系统时间
        organization.setCreationTime(new Date());
        try {
            organizationMapper.insertSelective(organization);
            for (TPetHospital tPetHospital : petHospitals) {
                tPetHospital.setOrganizationId(organization.getOrganizationId());
                tPetHospital.setCreationTime(new Date());
                petHospitalMapper.insertSelective(tPetHospital);
            }
            return DogResult.ok(organization.getOrganizationId());
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后再试");
        }
    }

    @Override
    public DogResult updateServiceSiteForYes(Integer organizationId, Integer power, Date approvalTime) throws Exception {
        try {
            organizationMapper.updateStatusForYes(organizationId, power, approvalTime);
            TOrganization organization = organizationMapper.selectByPrimaryKey(organizationId);
            //添加user
            TUsers user = new TUsers();
            user.setOrganizationId(organizationId);
            user.setName(organization.getPersonLiable());
            // 设置用户状态，默认启用(0.禁用，1.启用)
            user.setuStatus(1);
            // 设置登录次数，默认0
            user.setLoginNum(0);
            user.setRecentloginTime(new Date());
            user.setCreationTime(new Date());
            user.setUsername(organization.getUsername());
            user.setPassword(organization.getPassword());
            user.setPhone(organization.getPhone());
            //用户添加
            userMapper.insertUser(user);
            //添加用户与角色关联表
            TUserRefRoles userRefRoles = new TUserRefRoles();
            userRefRoles.setUserId(user.getUserId());
            //默认插入宠物医院角色
            userRefRoles.setRoleId(4);
            userRefRoles.setCreationTime(new Date());
            userRefRolesMapper.insertSelective(userRefRoles);
            //发送短信
            Map<String, String> params = new HashMap<>();
            params.put("phone", organization.getPhone());
            params.put("type", Integer.toString(14));
            Map<String, String> template_param = new HashMap<>();
            template_param.put("name", organization.getPersonLiable());
            template_param.put("orgName", organization.getOrganizationName());
            params.put("template_param", JSONObject.toJSONString(template_param));
//            HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
            new Thread(() -> {
                try {
                    HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }).start();
            return DogResult.ok();

        } catch (Exception e) {
            return DogResult.build(400,"服务器异常！！！");
        }
    }

    @Override
    public DogResult updateServiceSiteForNo(Integer organizationId, String failreason, Date approvalTime) throws Exception {
        int count = 0;
        try {
            count = organizationMapper.updateStatusForNo(organizationId, failreason, approvalTime);
        } catch (Exception e) {
            return DogResult.build(400, "操作失败！！！请稍后再试");
        }
        //发送短信
        Map<String, String> params = new HashMap<>();
        Map<String, String> map = organizationMapper.selectPhone(organizationId);
        params.put("phone", map.get("phone"));
        params.put("type", Integer.toString(7));
        Map<String, String> template_param = new HashMap<>();
        template_param.put("orgName", map.get("orgName"));
        if (failreason==null){
            failreason="";
        }
        template_param.put("result", "已驳回，驳回原因：" + failreason);

        new Thread(() -> {
            try {
                params.put("template_param", JSONObject.toJSONString(template_param));
                HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }).start();

        return DogResult.ok(count);
    }

    @Override
    public DogResult deleteServiceSite(Integer organizationId) throws Exception {
        try {
            int count = organizationMapper.deleteServiceSiteById(organizationId);
            return DogResult.ok(count);
        } catch (Exception e) {
            return DogResult.build(400, "删除失败！！！请稍后再试");
        }
    }

    @Override
    public List<ServiceSite> selectServiceSite(Integer provinceId, Integer ownedCityId, Integer districtId,
                                               Integer orgtype, Integer pageNum, Integer pageSize, Double ALon, Double ALat, Integer status, Integer power, String searchKey,Integer tType) throws Exception {
        try {

            List<ServiceSite> serviceSites = null;

            //有坐标信息就按照距离查询
            if (ALat != null && ALon > 0 && ALat != null && ALat > 0) {
                serviceSites = serviceSiteMapper.selectServiceSiteByDistance(ALat, ALon, provinceId, ownedCityId, districtId, status, orgtype, power, searchKey);
            } else {
                //普通查询
                serviceSites = serviceSiteMapper.selectServiceSite(provinceId, ownedCityId, districtId, status, orgtype, power, searchKey,tType);
            }
            for (ServiceSite serviceSite : serviceSites) {
                if (ALat != null && ALon > 0 && ALat != null && ALat > 0) {
                    // 获取两点之间的距离
                    double distance = FenceUtils.getDistance(ALat, ALon, serviceSite.getLatitude(), serviceSite.getLongitude());
                    serviceSite.setDistance(distance);
                }
                // 	获取serviceSite(对应类型9)对应的图片 医院logo
                List<TypeRefImages> images = typeRefImagesMapper.selectImagesByTypeAndId(9,
                        Integer.valueOf(serviceSite.getOrganizationId()).longValue());
                serviceSite.setPictureUrl(images);
                //获取网点证书图片
                List<TypeRefImages> typeRefImages = typeRefImagesMapper.selectImagesByTypeAndId(8,
                        Integer.valueOf(serviceSite.getOrganizationId()).longValue());
                serviceSite.setOrgCardImgs(typeRefImages);
            }
            return serviceSites;
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return null;
        }
    }

    @Override
    public ServiceSite selectServiceSite(Integer organizationId) throws Exception {
        try {
            ServiceSite serviceSite = serviceSiteMapper.selectServiceSiteById(organizationId);
            // 获取serviceSite(对应类型9)logo 对应的图片
            List<TypeRefImages> images = typeRefImagesMapper.selectImagesByTypeAndId(9,
                    Integer.valueOf(serviceSite.getOrganizationId()).longValue());

            // 获取serviceSite(对应类型8)证件 对应的图片
            List<TypeRefImages> images2 = new ArrayList<>();
            //获取服务站点所有申请材料证书
            List<TPetHospital> tPetHospitals = petHospitalMapper.selectTPetHospital(organizationId);
            tPetHospitals.stream().forEach(item -> {
                List<TypeRefImages> typeRefImages = typeRefImagesMapper.selectImagesByTypeAndId(8,
                        Integer.valueOf(item.getPetHCardId()).longValue());
                images2.addAll(typeRefImages);
            });
            serviceSite.setPictureUrl(images);
            serviceSite.setOrgCardImgs(images2);
            return serviceSite;
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ServiceSite> SelectNearServiceSite(Double ALon, Double ALat) throws Exception {
        List<ServiceSite> serviceSites = new ArrayList<>();
        try {
            // 获取全部服务网点
            List<ServiceSite> serviceSiteList = selectServiceSite(null, null, null, 1, null, null, null, null, 1, null, null,null);
            for (ServiceSite serviceSite : serviceSiteList) {
                // 获取两点之间的距离
                double distance = FenceUtils.getDistance(ALon, ALat, serviceSite.getLongitude().doubleValue(),
                        serviceSite.getLatitude().doubleValue());
                // 判断两点距离，若小于XXX，返回
                if (distance <= Double.parseDouble(ServiceSite_radius)) {
                    serviceSites.add(serviceSite);
                }
            }
            return serviceSites;
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TOrganization> selectOrganizationList(Integer orgType) {
        List<TOrganization> organizationList = organizationMapper.selectOrganizationList(orgType, 1);
        return organizationList;
    }

    @Override
    public int updateSite(ServiceSite site) {
//        TOrganization organization = new TOrganization();
//        BeanUtils.copyProperties(site, organization);
        return serviceSiteMapper.updateSite(site);
    }


}
