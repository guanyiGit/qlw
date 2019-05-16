package com.soholy.dogmanager.entity.device.cmd;

import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.TDeviceCommand;

import java.util.List;

public class CommandInfo extends TDevice {

    private List<TDeviceCommand> commands;

    public List<TDeviceCommand> getCommands() {
        return commands;
    }

    public void setCommands(List<TDeviceCommand> commands) {
        this.commands = commands;
    }
}
