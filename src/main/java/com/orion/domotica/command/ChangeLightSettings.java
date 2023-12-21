package com.orion.domotica.command;

import com.orion.domotica.device.LightBulb;

public class ChangeLightSettings implements Command {

    private LightBulb receiver;
    private float brightness;
    private boolean isOn;

    public ChangeLightSettings(LightBulb receiver, float brightness, boolean isOn) {
        this.receiver = receiver;
        this.brightness = brightness;
        this.isOn = isOn;
    }

    @Override
    public void execute() {
        receiver.setBrightness(brightness);
        receiver.setPower(isOn);
    }

}
