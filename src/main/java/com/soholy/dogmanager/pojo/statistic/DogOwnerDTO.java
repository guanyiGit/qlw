/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DogOwnerDTO
 * Author:   Administrator
 * Date:     2019/3/11 14:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.soholy.dogmanager.pojo.statistic;

import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.TDogOwner;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/3/11
 * @since 1.0.0
 */
public class DogOwnerDTO extends TDogOwner {

    private Long dogOwnerCardId;//犬主证件id

    private Integer cardType;//犬主证件类型

    private String cardNum;//犬主证件号码

    private String districtName;//区域名称

    private List<TDogInfo> dogInfo;// 犬只

    private String password;//密码

    private String yzm;//验证码

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Long getDogOwnerCardId() {
        return dogOwnerCardId;
    }

    public void setDogOwnerCardId(Long dogOwnerCardId) {
        this.dogOwnerCardId = dogOwnerCardId;
    }

    public List<TDogInfo> getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(List<TDogInfo> dogInfo) {
        this.dogInfo = dogInfo;
    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
