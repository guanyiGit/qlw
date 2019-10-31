package com.soholy.dogmanager.oauth;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 同步业务信息
 */
public class AepSynBusiInfo extends  BaseMessage {
    private String operType; //操作类型；add:新订购应用，modify:变更应用，del;//退订应用
    private Integer tenantId;// 租户 ID
    private Integer itemInstId;// 商品实例
    private Integer itemId;// 商品
    private Integer orderNo;// 订单号
    private String chargeType;// 计费方式（fix：固定终端数，active:激活终端数，import：导入终端数）
    private Integer chargeCycle;// 计费周期（月）
    private String appKey;// 应用 Key
    private String appSecret;// 应用 Secret
    private List<T> prodList;// 产品列表 Object 数组 N
    private Integer prodInstId;// 产品实例 ID
    private String prodOperType;// 产品操作类型，变更业务需要: add:新订购应用，modify:变更应用，del:退订应用;
    private String masterKey;// DM 模块返回的 masterKey,新订购时必传
    private Integer prodId;// 产品 ID(设备类型的 ID)
    private Integer prodQuantity;// 产品数量（只有固定终端数才有值
    private Double prodPrice;// 产品单价(元)

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getItemInstId() {
        return itemInstId;
    }

    public void setItemInstId(Integer itemInstId) {
        this.itemInstId = itemInstId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getChargeCycle() {
        return chargeCycle;
    }

    public void setChargeCycle(Integer chargeCycle) {
        this.chargeCycle = chargeCycle;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public List<T> getProdList() {
        return prodList;
    }

    public void setProdList(List<T> prodList) {
        this.prodList = prodList;
    }

    public Integer getProdInstId() {
        return prodInstId;
    }

    public void setProdInstId(Integer prodInstId) {
        this.prodInstId = prodInstId;
    }

    public String getProdOperType() {
        return prodOperType;
    }

    public void setProdOperType(String prodOperType) {
        this.prodOperType = prodOperType;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(Integer prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }
}
