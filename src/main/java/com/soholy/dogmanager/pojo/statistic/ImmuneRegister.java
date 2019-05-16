/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImmuneRegister
 * Author:   Administrator
 * Date:     2019/2/22 17:15
 * Description: 免疫登记
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.soholy.dogmanager.pojo.statistic;

import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.entity.dogCard.DogInfo;
import com.soholy.dogmanager.entity.dogCard.ImmuneCard;

/**
 * 〈一句话功能简述〉<br> 
 * 〈免疫登记〉
 *
 * @author Administrator
 * @create 2019/2/22
 * @since 1.0.0
 */
public class ImmuneRegister {

    private TDogOwner dogOwner;//犬主
    private TDogOwnerCard dogOwnerCard;//犬主证件
    private TDogInfo dogInfo;//犬只
    private ImmuneCard immuneCard;//免疫证

    private TVaccineRegister vaccineRegister;//免疫登记
    private TVaccineInjection vaccineInjection;//免疫记录


    public TDogOwnerCard getDogOwnerCard() {
        return dogOwnerCard;
    }

    public void setDogOwnerCard(TDogOwnerCard dogOwnerCard) {
        this.dogOwnerCard = dogOwnerCard;
    }

    public TVaccineRegister getVaccineRegister() {
        return vaccineRegister;
    }

    public void setVaccineRegister(TVaccineRegister vaccineRegister) {
        this.vaccineRegister = vaccineRegister;
    }

    public TVaccineInjection getVaccineInjection() {
        return vaccineInjection;
    }

    public void setVaccineInjection(TVaccineInjection vaccineInjection) {
        this.vaccineInjection = vaccineInjection;
    }

    public TDogOwner getDogOwner() {
        return dogOwner;
    }

    public void setDogOwner(TDogOwner dogOwner) {
        this.dogOwner = dogOwner;
    }

    public TDogInfo getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(TDogInfo dogInfo) {
        this.dogInfo = dogInfo;
    }

    public ImmuneCard getImmuneCard() {
        return immuneCard;
    }

    public void setImmuneCard(ImmuneCard immuneCard) {
        this.immuneCard = immuneCard;
    }
}
