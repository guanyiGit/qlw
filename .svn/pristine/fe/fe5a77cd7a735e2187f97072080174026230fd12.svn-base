package com.soholy.dogmanager.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.utils.MathUtils;
import com.soholy.dogmanager.common.utils.Md5Encode;
import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.entity.TUserRefRoles;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.entity.user.EditRoleAndOrg;
import com.soholy.dogmanager.mapper.TRolesMapper;
import com.soholy.dogmanager.mapper.TUserRefRolesMapper;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.mapper.user.UserInfoMapper;
import com.soholy.dogmanager.mapper.user.UserRefRolesMapper;
import com.soholy.dogmanager.pojo.user.UserInfo;
import com.soholy.dogmanager.pojo.user.UserRefRoles;
import com.soholy.dogmanager.pojo.user.UserVo;
import com.soholy.dogmanager.service.user.UserService;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUsersMapper userMapper;

    @Autowired
    private TUserRefRolesMapper tUserRefRolesMapper;

    @Autowired
    private UserRefRolesMapper userRefRolesMapper;

    @Autowired
    private TRolesMapper rolesMapper;

    @Autowired
    private UserInfoMapper userRefDeviceMapper;

    @Value("${RESET_PASSWORD}")
    private String resetpassword;

    @Value("${SMS_BASE_URL}")
    private String sms_base_url;

    @Override
    public DogResult checkPhone(String phone) {
        try {
            List<TUsers> list = userMapper.selectUserByPhone(phone);
            if (list != null && list.size() > 0) {
                // 请求成功，数据库已存在数据，数据不可用
                return DogResult.ok(false);
            }
            return DogResult.ok(true);
        } catch (Exception e) {
            return DogResult.build(400,"服务器异常！！！");
        }
    }

    @Override
    public DogResult checkUserName(String username) {
        try {
            TUsers users = userMapper.selectUserByUserName(username);
            if (users != null && !users.equals("")) {
                // 请求成功，数据库已存在数据，数据不可用
                return DogResult.ok(false);
            }
            return DogResult.ok(true);
        } catch (Exception e) {
            return DogResult.build(400,"服务器异常！！！");
        }
    }

    @Override
    public DogResult checkEmail(String email) {
        try {
            List<TUsers> list = userMapper.selectUserByEmail(email);
            if (list != null && list.size() > 0) {
                // 请求成功，数据库已存在数据，数据不可用
                return DogResult.ok(false);
            }
            return DogResult.ok(true);
        } catch (Exception e) {
            return DogResult.build(400,"服务器异常！！！");
        }
    }
    /**
     * 添加用户
     * */
    @Override
    public void saveUser(UserVo userVo){
        //1.用户添加
        TUsers user = new TUsers();
        BeanUtils.copyProperties(userVo, user);
        user.setUsername(user.getPhone());
        user.setuStatus(1); // 设置用户状态，默认启用(0.禁用，1.启用)
        user.setLoginNum(0);// 设置登录次数，默认0
        user.setDogOwnId(user.getDogOwnId());
        user.setRecentloginTime(new Date());
        user.setCreationTime(new Date());
        // 获取随机密码，加密后存入数据库
        String randomNumber = MathUtils.getRandomNumber();
        String password = Md5Encode.getCredentials(user.getUsername(), randomNumber).toString();
        user.setPassword(password);
        userMapper.insertUser(user);

        // 2.发短信
        Map<String, String> params = new HashMap<>();
        params.put("phone", user.getPhone());
        Map<String, String> template_param = new HashMap<>();
        template_param.put("name", user.getName());
        template_param.put("username", user.getUsername());
        template_param.put("password", randomNumber);
        params.put("template_param", JSONObject.toJSONString(template_param));
        new Thread(() -> {
            try {
                HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/PassWordSMS", "post", params);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }).start();

        // 3.添加角色关联表
            TUserRefRoles tUserRefRoles = new TUserRefRoles();
            tUserRefRoles.setUserId(user.getUserId());
            tUserRefRoles.setRoleId(userVo.getRoleId());
            tUserRefRoles.setCreationTime(new Date());
            tUserRefRolesMapper.insert(tUserRefRoles);

    }



    @Override
    public DogResult addUser(UserVo userVo) {
        try {
            TUsers user = new TUsers();
            PropertyUtils.copyProperties(user, userVo);
            // 检查数据有效性
            DogResult result = checkPhone(user.getPhone());
            if (!(Boolean) result.getData()) {
                return DogResult.build(400, "电话已被注册，请重新输入");
            }
//            如果邮箱不为空，那么接着判断是否重复，邮箱是不能重复的
//            result = checkEmail(user.getEmail());
//            if (!(Boolean) result.getData()) {
//                return DogResult.build(403, "邮箱已被注册");
//            }
//			user.setName(new String(user.getName().getBytes("ISO-8859-1"), "UTF-8"));
            // 设置用户名(默认为电话号码)
            user.setUsername(user.getPhone());
            // 设置用户状态，默认启用(0.禁用，1.启用)
            user.setuStatus(1);
            // 设置登录次数，默认0
            user.setLoginNum(0);
            user.setDogOwnId(user.getDogOwnId());
            user.setRecentloginTime(new Date());
            user.setCreationTime(new Date());
            // 获取随机密码，加密后存入数据库
            String randomNumber = MathUtils.getRandomNumber();
            String password = Md5Encode.getCredentials(user.getUsername(), randomNumber).toString();
            user.setPassword(password);
            //用户添加
            userMapper.insertUser(user);
            // 添加user成功后发送短信到用户电话上(另起一个线程)
			Map<String, String> params = new HashMap<>();
			params.put("phone", user.getPhone());
			Map<String, String> template_param = new HashMap<>();
            template_param.put("name",user.getName());
			template_param.put("username", user.getUsername());
			template_param.put("password", randomNumber );
			params.put("template_param", JSONObject.toJSONString(template_param));
            new Thread(() -> {
                try {
                    HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/PassWordSMS", "post", params);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }).start();


            // 添加角色
            if (userVo.getRoleId() != null && !userVo.getRoleId().equals("")) {
//				TRoles role = rolesMapper.selectByPrimaryKey(userVo.getRoleId());
                TUserRefRoles tUserRefRoles = new TUserRefRoles();
                tUserRefRoles.setUserId(user.getUserId());
                tUserRefRoles.setRoleId(userVo.getRoleId());
                tUserRefRoles.setCreationTime(new Date());
                tUserRefRolesMapper.insert(tUserRefRoles);
                return DogResult.ok();
            }
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public DogResult thirdAddUser(UserVo userVo) {
        try {
            TUsers user = new TUsers();
            PropertyUtils.copyProperties(user, userVo);
            // 检查数据有效性
            DogResult result = checkPhone(user.getPhone());
            if (!(Boolean) result.getData()) {
                return DogResult.build(400, "电话已被注册，请重新输入");
            }
            // 设置用户名(默认为电话号码)
            user.setUsername(user.getPhone());
            // 设置用户状态，默认启用(0.禁用，1.启用)
            user.setuStatus(1);
            // 设置登录次数，默认0
            user.setLoginNum(0);
            user.setDogOwnId(user.getDogOwnId());
            user.setRecentloginTime(new Date());
            user.setCreationTime(new Date());
            // 获取密码，加密后存入数据库
            String password = Md5Encode.getCredentials(user.getUsername(), userVo.getPassword()).toString();
            user.setPassword(password);
            //用户添加
            userMapper.insertUser(user);
            // 添加角色
            if (userVo.getRoleId() != null && !userVo.getRoleId().equals("")) {
//				TRoles role = rolesMapper.selectByPrimaryKey(userVo.getRoleId());
                TUserRefRoles tUserRefRoles = new TUserRefRoles();
                tUserRefRoles.setUserId(user.getUserId());
                tUserRefRoles.setRoleId(userVo.getRoleId());
                tUserRefRoles.setCreationTime(new Date());
                tUserRefRolesMapper.insert(tUserRefRoles);
                return DogResult.ok();
            }
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public DogResult assignRole(List<TUserRefRoles> list) {
        try {
            // 先删除用户与原角色关系
            list.stream().forEach(x -> {
                x.setCreationTime(Calendar.getInstance().getTime());
                tUserRefRolesMapper.deleteUserRefRoleByUserId(x.getUserId());
            });
            //组件角色信息对象
            tUserRefRolesMapper.addUserRefRole(list);
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public List<TUsers> selectUsers() {
        // 查询所有启用状态的用户
        return this.selectUsersByStatus(1);
    }

    @Override
    public List<TUsers> selectUsersByStatus(Integer status) {
        try {
            List<TUsers> usersByStatus = userMapper.selectUsersByStatus(status);
            return usersByStatus;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TUsers> selectUsersByOrgType(Integer type) {
        try {
            List<TUsers> usersByStatus = userMapper.selectUsersByOrgType(type);
            return usersByStatus;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TUsers getUserById(Long userId) {
        try {
            TUsers user = userMapper.selectByPrimaryKey(userId);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public UserInfo getUserInfo(Long userId) throws Exception {
        UserInfo userInfo = userRefDeviceMapper.selectUserInfo(userId);
        return userInfo;
    }

    @Override
    public TUsers getUserByUserName(String username) {
        try {
            TUsers user = userMapper.selectUserByUserName(username);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public DogResult resetPassWord(Long userId) {
        try {
            int count = userMapper.resetPassWord(userId, resetpassword);
            return DogResult.ok(count);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public DogResult updateUserPassword(Long userId, String oldPassword, String newPassword) {
        try {
            TUsers user = userMapper.selectByPrimaryKey(userId);
            // 检查旧密码是否正确
            if (Md5Encode.getCredentials(user.getUsername(), oldPassword).toString().equals(user.getPassword())) {
                // 正确，新密码加密插入数据库
                userMapper.updateUserPwdById(userId,
                        Md5Encode.getCredentials(user.getUsername(), newPassword).toString());
                return DogResult.ok();
            } else {
                return DogResult.build(400, "原密码不正确");
            }
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public DogResult updateUser(TUsers user, String roleIds) {
        try {
            String[] roleIdes = roleIds.split(",");
            // 先删除用户与原角色关系
            tUserRefRolesMapper.deleteUserRefRoleByUserId(user.getUserId());
            // 添加用户与角色关联关系
            List<TUserRefRoles> tUserRefRolesList = new ArrayList<>();
            for (String roleId : roleIdes) {
                TUserRefRoles tUserRefRoles = new TUserRefRoles();
                tUserRefRoles.setUserId(user.getUserId());
                tUserRefRoles.setRoleId(Integer.parseInt(roleId));
                tUserRefRoles.setCreationTime(new Date());
                tUserRefRolesList.add(tUserRefRoles);
            }
            tUserRefRolesMapper.addUserRefRole(tUserRefRolesList);
            // 更新用户信息
            userMapper.updateByPrimaryKeySelective(user);
            // 判断角色是否改变
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public DogResult updateLoginNum(Long userId) {
        try {
            // 获取user
            TUsers user = userMapper.selectByPrimaryKey(userId);
            // 更新登录次数
            user.setLoginNum(user.getLoginNum() + 1);
            // 更新登录时间
            user.setRecentloginTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public DogResult deleteUser(Long userId) {
        try {
            // 删除用户
            userMapper.deleteByPrimaryKey(userId);
//			userMapper.updataStatus(userId, 3);
            // 删除用户与角色管关联关系
            tUserRefRolesMapper.deleteUserRefRoleByUserId(userId);
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public UserRefRoles selectByUserId(Long userId) {
        try {
            UserRefRoles userRefRoles = userRefRolesMapper.selectRolesByUserId(userId);
            return userRefRoles;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserRefRoles> selectUserRefRoles() {
        return this.selectUserRefRoles(1);
    }

    @Override
    public List<UserRefRoles> selectUserRefRoles(Integer status) {
        try {
            List<UserRefRoles> userRefRoles = userRefRolesMapper.selectUserRefRoles(status);
            return userRefRoles;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserVo> selectUserVo(String query) {
        return this.selectUserVo(null, query);
    }

    @Override
    public List<UserVo> selectUserVo(Integer status, String query) {
        try {
            List<UserVo> userVos = userRefRolesMapper.selectUserVo(status, query);
            return userVos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DogResult updataStatus(Long userId, Integer status) {
        try {
            userMapper.updataStatus(userId, status);
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
    }

    @Override
    public boolean modifyUserLoginInfoById(TUsers user) {
        if (user != null && user.getUserId() != null) {
            int loginNum = user.getLoginNum() == null ? 0 : user.getLoginNum() + 1;//登陸次數
            user.setRecentloginTime(Calendar.getInstance().getTime());
            user.setLoginNum(loginNum);

            //登录信息
            userMapper.saveLoginInfo(user.getUserId(), Calendar.getInstance().getTime(), null);

            return 1 == userMapper.updateByPrimaryKeySelective(user);

        }
        return false;
    }

    @Override
    public boolean editByIds(List<TUsers> tUserss) {
        if (tUserss != null && tUserss.size() > 0) {
            Integer count = tUserss.stream()
                    .filter(x -> x.getUserId() != null)
                    .map(x -> userMapper.updateByPrimaryKeySelective(x))
                    .reduce(0, (x, y) -> x + y);
            return count == tUserss.size();
        }
        return false;
    }

    @Override
    public DogResult updatePhone(Long userId, String phone) {
        TUsers user = userMapper.selectByPrimaryKey(userId);
        // 检查数据有效性
        DogResult result = checkPhone(phone);
        if (!(Boolean) result.getData()) {
            return DogResult.build(400, "用户名或电话已存在");
        }
        user.setUsername(phone);
        user.setPhone(phone);
        //由于更改了电话即用户名，所以需要重新生成密码并用短信发送给用户
        // 获取随机密码，加密后存入数据库
        String randomNumber = MathUtils.getRandomNumber();
        String password = Md5Encode.getCredentials(phone, randomNumber).toString();
        user.setPassword(password);
        //用户添加
        userMapper.updateByPrimaryKey(user);
        // 添加user成功后发送短信到用户电话上(另起一个线程)
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        Map<String, String> template_param = new HashMap<>();
        template_param.put("name",user.getName());
        template_param.put("username", user.getUsername());
        template_param.put("password", randomNumber);
        params.put("template_param", JSONObject.toJSONString(template_param));
        new Thread(()->{
            try {
                HttpResult httpResult  = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }).start();
        return DogResult.ok();
    }

    @Transactional
    @Override
    public DogResult editRoleAndOrg(EditRoleAndOrg editRoleAndOrg) {
        List<TUsers> users = editRoleAndOrg.getUsers();
        TRoles role = editRoleAndOrg.getRole();
        TOrganization organization = editRoleAndOrg.getOrganization();
        List<TUserRefRoles> userRefRoles = new ArrayList<>();
        users.stream().forEach(item -> {
            //创建userRefRole对象
            TUserRefRoles userRefRole = new TUserRefRoles();
            userRefRole.setUserId(item.getUserId());
            userRefRole.setRoleId(role.getRoleId());
            userRefRole.setCreationTime(new Date());
            userRefRoles.add(userRefRole);
            //修改用户所属组织
            item.setOrganizationId(organization.getOrganizationId());
            item.setOrgType(organization.getOrgType());
            userMapper.updateByPrimaryKeySelective(item);

        });
        DogResult dogResult = this.assignRole(userRefRoles);
        if (dogResult.getStatus() != 200){
            throw new RuntimeException();
        }
        return dogResult;
    }

    @Override
    public DogResult retrievePwd(String username, String newPassword){
        try {
            TUsers tUsers = userMapper.selectUserByUserName(username);
            String password = Md5Encode.getCredentials(username, newPassword).toString();
            int i = userMapper.updateUserPwdById(tUsers.getUserId(), password);
            return DogResult.ok(i);
        } catch (Exception e) {
            return DogResult.build(400,"服务器异常，请稍后再试");
        }
    }
}
