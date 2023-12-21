package com.orion.domotica.command;

import com.orion.domotica.device.SmartPlug;

public class ChangePlugSettings implements Command {

    private final SmartPlug receiver;
    private final boolean power;

    public ChangePlugSettings(SmartPlug receiver, boolean power) {
        this.receiver = receiver;
        this.power = power;
    }

    @Override
    public void execute() {
        receiver.setPower(power);
    }

}
