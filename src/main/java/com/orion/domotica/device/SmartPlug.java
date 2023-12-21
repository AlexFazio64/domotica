package com.orion.domotica.device;

public class SmartPlug extends Device {
    private boolean power;

    public SmartPlug(String deviceId, String deviceName, Integer owner) {
        super(deviceId, deviceName, owner);
        this.power = true;
    }

    public boolean isOn() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + ";" + super.toString() + ";" + power + ";-\n";
    }
}
