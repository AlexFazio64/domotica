package com.orion.domotica.Factory;

import com.orion.domotica.device.Device;
import com.orion.domotica.device.LightBulb;

public class LightFactory implements Factory {

    @Override
    public Device createDevice(String id, String name, int owner) {
        return new LightBulb(id, name, owner);
    }

}
