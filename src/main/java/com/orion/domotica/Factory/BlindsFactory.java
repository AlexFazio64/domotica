package com.orion.domotica.Factory;

import com.orion.domotica.device.Blinds;
import com.orion.domotica.device.Device;

public class BlindsFactory implements Factory {

    @Override
    public Device createDevice(String id, String name, int owner) {
        return new Blinds(id, name, owner);
    }

}
