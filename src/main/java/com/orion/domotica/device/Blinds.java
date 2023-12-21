package com.orion.domotica.device;

public class Blinds extends Device {

    private float position;

    public Blinds(String deviceId, String deviceName, Integer owner) {
        super(deviceId, deviceName, owner);
        this.position = 0;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + ";" + super.toString() + ";-;" + position + "\n";
    }

}
