package com.orion.domotica.scenario;

import java.util.ArrayList;
import java.util.List;

import com.orion.domotica.device.Device;
import com.orion.domotica.user.User;

public class Scenario {
    private String scenarioName;
    private List<Device> devices;

    public Scenario(String scenarioName) {
        this.scenarioName = scenarioName;
        this.devices = new ArrayList<>();
    }

    // Aggiunge un dispositivo allo scenario(Da Modificare)
    public void addDevice(Device device) {
        devices.add(device);
    }

    // Rimuove un dispositivo dallo scenario
    public void removeDevice(Device device) {
        devices.remove(device);
    }

    // Restituisce la lista di dispositivi nello scenario
    public List<Device> getDevices() {
        return new ArrayList<>(devices); // Ritorna una copia per evitare modifiche esterne non controllate
    }

    // Verifica se l'utente è autorizzato ad eseguire lo scenario
    public boolean isUserAuthorized(User user) {
        // Implementa la logica di autorizzazione, ad esempio, controlla il ruolo
        // dell'utente
        return user.isAdmin();
    }
}
