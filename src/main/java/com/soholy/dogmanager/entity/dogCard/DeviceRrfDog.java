package com.soholy.dogmanager.entity.dogCard;

import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.TDeviceRefDog;

import java.util.List;

public class DeviceRrfDog {

    private TDevice tDevice;
    private List<TDeviceRefDog> tDeviceRefDog;

    public List<TDeviceRefDog> gettDeviceRefDog() {
        return tDeviceRefDog;
    }

    public void settDeviceRefDog(List<TDeviceRefDog> tDeviceRefDog) {
        this.tDeviceRefDog = tDeviceRefDog;
    }

    public TDevice gettDevice() {
        return tDevice;
    }

    public void settDevice(TDevice tDevice) {
        this.tDevice = tDevice;
    }
}
