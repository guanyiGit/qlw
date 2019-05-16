package com.soholy.dogmanager.controller.reservation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.controller.shiro.BaseController;
import com.soholy.dogmanager.entity.TAppointment;
import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.service.reservation.ReservationService;
import com.soholy.dogmanager.service.reservation.ReserveInformation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author guanY
 * @version 1.0.0
 * @ClassName ReservationController
 * @Description (预约业务)
 * @Date 2018年9月8日 下午8:44:55
 */
@RestController
@RequestMapping(value = "/biz/reservation")
public class ReservationController extends BaseController {

    Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private ReservationService reservationService;

    /**
     * @param userId  用户id
     * @param keyWord
     * @return
     * @Description (查询我的预约列表 - - 个人)
     */
    @RequiresPermissions("/reservation/lsit")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String list(@RequestParam(value = "userId") Long userId,
                       @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                       @RequestParam(value = "keyWord", required = false) String keyWord) {

        PageHelper.startPage(pageNum, pageSize);
        List<ReserveInformation> lists = reservationService.findAppointmentsByUserIdAndLikeHospitalName(userId,
                keyWord);

        return new GlobalResult().successJSON(new PageInfo<ReserveInformation>(lists));
    }

    /**
     * @param orgId  机构id
     * @param keyWord
     * @return
     * @Description (查询我的预约业务列表 - - 机构)
     */
    @RequiresPermissions("/reservation/orglist")
    @RequestMapping(value = "/org", method = RequestMethod.GET)
    public String orglist(@RequestParam(value = "orgId") Long orgId,
                          @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                          @RequestParam(value = "keyWord", required = false) String keyWord) {

        PageHelper.startPage(pageNum, pageSize);
        List<ReserveInformation> lists = reservationService.findAppointmentsByOrgIdAndLikeUserInfo(orgId, keyWord);
        return new GlobalResult().successJSON(new PageInfo<ReserveInformation>(lists));
    }

    /**
     * @param tAppointment bizType 0看病，1办证，2年检，3预约, not null
     *                     appointmentName 用户姓名
     *                     appointmentPhone 用户电话
     *                     appointmentChannel 0电话预约，1网上预约，2门店预约，3其他 ,not null
     *                     remarks 备注
     *                     scheduleTime 约定时间
     *                     orgId 机构id, not null
     *                     userId 预约用户id
     * @return
     * @Description (新增预约)
     */
    //@RequiresPermissions("/reservation/add")
    @RequestMapping(method = RequestMethod.POST)
    public String add(TAppointment tAppointment) {
        if (tAppointment != null && tAppointment.getBizType() != null && tAppointment.getAppointmentChannel() != null) {
            Integer bizType = tAppointment.getBizType();
            Integer appointmentChannel = tAppointment.getAppointmentChannel();
                tAppointment.setCreationTime(Calendar.getInstance().getTime());
                boolean bool = reservationService.saveAppointment(tAppointment);
            return new GlobalResult().boolResultJSON(bool);
        }
        return new GlobalResult().failureJSON();
    }

    /**
     * @param appointmentId
     * @return
     * @Description (删除预约记录)
     */
    //@RequiresPermissions("/reservation/delete")
    @RequestMapping(value = "/delete/{appointmentId}", method = RequestMethod.POST)
    public String delete(@PathVariable("appointmentId") Long appointmentId) {
        if (appointmentId != null) {
            boolean bool = reservationService.removeByid(appointmentId);
            return new GlobalResult().boolResultJSON(bool);
        }
        return new GlobalResult().failureJSON();
    }

    /**
     * @return dicName, decType
     * @Description (预约方式查询)
     */
    @RequestMapping(value = "/mode", method = RequestMethod.GET)
    public String modeList() {
        List<Map<String, String>> List = reservationService.findAppointmentChannelAll();
        return new GlobalResult().successJSON(List);
    }

    /**
     * @return
     * @Description (查询预约方式列表)
     */
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public String typeList() {
        List<TDictionary> List = reservationService.findBizTypes();
        return new GlobalResult().successJSON(List);
    }

    /**
     * @param tAppointment bizType 0看病，1办证，2年检，3预约, not null
     *                     appointmentName 用户姓名
     *                     appointmentPhone 用户电话
     *                     appointmentChannel 0电话预约，1网上预约，2门店预约，3其他 ,not null
     *                     remarks 备注
     *                     scheduleTime 约定时间
     *                     orgId 机构id, not null
     *                     userId 预约用户id
     *                     status 0未赴约，1已赴约
     * @return
     * @Description (修改预约信息 ， 根据预约id)
     */
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public String modify(TAppointment tAppointment) {
        GlobalResult result = new GlobalResult();
        result.failureJSON("参数错误!");
        if (tAppointment == null || tAppointment.getAppointmentId() == null) {
            return result.failureJSON("参数错误!");
        }
        return result.boolResultJSON(reservationService.modefyById(tAppointment));
    }

}
