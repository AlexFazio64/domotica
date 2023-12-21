package com.orion.domotica.command;

import com.orion.domotica.device.Blinds;

public class ChangeBlindsSettings implements Command {

    private final Blinds receiver;
    private final float position;

    public ChangeBlindsSettings(Blinds receiver, float position) {
        this.receiver = receiver;
        this.position = position;
    }

    @Override
    public void execute() {
        receiver.setPosition(position);
    }

}
