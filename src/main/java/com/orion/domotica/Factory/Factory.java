package com.orion.domotica.Factory;

import com.orion.domotica.device.Device;

public interface Factory {
    public Device createDevice(String id, String name, int owner);
}
