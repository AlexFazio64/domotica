package com.orion.domotica.device;

import java.util.ArrayList;

public abstract class Device {
    private String deviceId;
    private String deviceName;
    private ArrayList<Integer> owners;

    // Costruttore
    public Device(String deviceId, String deviceName, Integer owner) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.owners = new ArrayList<Integer>();
        this.owners.add(owner);
    }

    // Metodo per aggiungere un nuovo proprietario
    public void addOwner(int owner) {
        this.owners.add(owner);
    }

    // Metodo per rimuovere un proprietario
    public void removeOwner(int owner) {
        this.owners.remove(owner);
    }

    // Metodo per ottenere i dettagli del dispositivo
    public String getDetails() {
        return "Device ID: " + deviceId + "\nDevice Name: " + deviceName;
    }

    // Metodo per ottenere il device ID
    public String getDeviceId() {
        return deviceId;
    }

    // Metodo per ottenere il nome del dispositivo
    public String getDeviceName() {
        return deviceName;
    }

    public ArrayList<Integer> getOwners() {
        return owners;
    }

    @Override
    public String toString() {
        return deviceId + ";" + deviceName + ";" + owners;
    }
}
