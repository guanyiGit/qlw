package com.soholy.dogmanager.entity.device;

import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.TDeviceFactory;
import com.soholy.dogmanager.entity.TDeviceModel;
import com.soholy.dogmanager.entity.TOrganization;

public class DeviceRefModelInfo extends TDevice {


    private TOrganization tOrganization;
    private TDeviceModel tDeviceModel;
    private TDeviceFactory tDeviceFactory;

    public TOrganization gettOrganization() {
        return tOrganization;
    }

    public void settOrganization(TOrganization tOrganization) {
        this.tOrganization = tOrganization;
    }

    public TDeviceModel gettDeviceModel() {
        return tDeviceModel;
    }

    public void settDeviceModel(TDeviceModel tDeviceModel) {
        this.tDeviceModel = tDeviceModel;
    }

    public TDeviceFactory gettDeviceFactory() {
        return tDeviceFactory;
    }

    public void settDeviceFactory(TDeviceFactory tDeviceFactory) {
        this.tDeviceFactory = tDeviceFactory;
    }
}
