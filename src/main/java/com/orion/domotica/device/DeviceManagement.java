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

    // Restituisce la lista di tutti i dispositivi
    public List<Device> getAllDevices() {
        return new ArrayList<>(deviceList); // Ritorna una copia per evitare modifiche esterne non controllate
    }

    // Esegue un'operazione su un dispositivo
    public void performDeviceOperation(User user, Device device, String operation) {
        if (user.isAdmin()) {
            device.performOperation(operation);
        } else {
            System.out.println("Accesso negato. L'utente non ha i permessi necessari.");
        }
    }

    // Altri metodi utili possono essere aggiunti in base alle esigenze...
}
