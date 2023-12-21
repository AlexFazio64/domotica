package com.orion.domotica.action;

import java.util.HashMap;
import java.util.Map;

import com.orion.domotica.device.Device;

public class Action {
    private String nomeAzione;
    private Map<String, Object> parametri;

    public Action(String nomeAzione) {
        this.nomeAzione = nomeAzione;
        this.parametri = new HashMap<>();
    }

    // Metodo per impostare un parametro specifico dell'azione automatica
    public void setParametro(String nomeParametro, Object valore) {
        parametri.put(nomeParametro, valore);
    }

    // Metodo per ottenere un parametro specifico dell'azione automatica
    public Object getParametro(String nomeParametro) {
        return parametri.get(nomeParametro);
    }

    // Esegue l'azione automatica
    public void eseguiAzioneAutomatica(Device dispositivo) {
        System.out.println("Esecuzione dell'azione automatica '" + nomeAzione + "' su dispositivo " + dispositivo.getDeviceName());
    }
}
