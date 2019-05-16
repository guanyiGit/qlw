package com.soholy.dogmanager.oauth;
import org.apache.poi.ss.formula.functions.T;
import java.util.List;

public class AddDeleteDevice extends BaseMessage{
    private String operType;// add”:新增导入；del”:删除导入
    private Integer tenantId;// 租户 ID
    private Integer productId;// 产品实例 ID（私有产品 ID
    private Integer saasId;// 商品实例 ID
    private List<T> deviceList;// 导入的设备列表 Object 数
    private Integer deviceId;// 设备实例 ID
    private String deviceSn;// 设备串号(mqtt,t-link 协议的设备有效)
    private String imei;// 设备 imei 码（Nb 网关,Lwm2m 设备有效

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSaasId() {
        return saasId;
    }

    public void setSaasId(Integer saasId) {
        this.saasId = saasId;
    }

    public List<T> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<T> deviceList) {
        this.deviceList = deviceList;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
