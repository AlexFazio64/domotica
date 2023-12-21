package com.orion.domotica.Factory;

import com.orion.domotica.device.Device;
import com.orion.domotica.device.SmartPlug;

public class PlugFactory implements Factory {

    @Override
    public Device createDevice(String id, String name, int owner) {
        return new SmartPlug(id, name, owner);
    }
}
