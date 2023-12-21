package com.orion.domotica.device;

import java.util.ArrayList;
import java.util.List;

import com.orion.domotica.user.User;

public class DeviceManagement {
    private List<Device> deviceList;

    public DeviceManagement() {
        this.deviceList = new ArrayList<>();
    }

    // Aggiunge un nuovo dispositivo alla lista
    public void addDevice(Device device) {
        deviceList.add(device);
    }

    public Device getDeviceById(String deviceId) {
        for (Device device : deviceList) {
            if (device.getDeviceId().equals(deviceId)) {
                return device;
            }
        }
        return null;
    }

    // Restituisce la lista di tutti i dispositivi
    public List<Device> getAllDevices() {
        return new ArrayList<>(deviceList);
    }

    public ArrayList<Device> getDevicesByUser(User user) {
        ArrayList<Device> devices = new ArrayList<>();
        for (Device device : deviceList) {
            if (device.getOwners().contains((Integer) user.userId)) {
                devices.add(device);
            }
        }
        return devices;
    }

    public Device createDevice(String id, String name, ArrayList<Integer> owners, String status, String value) {

        return null;
    }

    public void reset() {
        deviceList.clear();
    }
}
