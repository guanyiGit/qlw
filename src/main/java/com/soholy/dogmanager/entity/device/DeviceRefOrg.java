package com.soholy.dogmanager.entity.device;

import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.TOrganization;

public class DeviceRefOrg extends TDevice {

    private TOrganization tOrganization;

    public TOrganization gettOrganization() {
        return tOrganization;
    }

    public void settOrganization(TOrganization tOrganization) {
        this.tOrganization = tOrganization;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeviceRefOrg{");
        sb.append("tOrganization=").append(tOrganization);
        sb.append('}');
        return sb.toString();
    }
}
