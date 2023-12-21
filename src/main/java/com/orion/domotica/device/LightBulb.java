package com.orion.domotica.device;

public class LightBulb extends Device {
    private boolean isOn;
    private float brightness;
    private final float minBrightness;
    private final float maxBrightness;

    public LightBulb(String deviceId, String deviceName, Integer owner) {
        super(deviceId, deviceName, owner);
        this.isOn = true;
        this.brightness = 100;
        this.minBrightness = 5;
        this.maxBrightness = 100;
    }

    public boolean isOn() {
        return isOn;
    }

    public float getBrightness() {
        return brightness;
    }

    public float getMinBrightness() {
        return minBrightness;
    }

    public float getMaxBrightness() {
        return maxBrightness;
    }

    public void setPower(boolean power) {
        this.isOn = power;
    }

    public void setBrightness(float brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + ";" + super.toString() + ";" + isOn + ";" + brightness + "\n";
    }
}
