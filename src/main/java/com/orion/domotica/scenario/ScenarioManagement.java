package com.orion.domotica.scenario;
import java.util.ArrayList;
import java.util.List;

import com.orion.domotica.user.User;

public class ScenarioManagement {
    private List<Scenario> scenarioList;

    public ScenarioManagement() {
        this.scenarioList = new ArrayList<>();
    }

    // Aggiunge uno scenario alla lista
    public void addScenario(Scenario scenario) {
        scenarioList.add(scenario);
    }

    // Rimuove uno scenario dalla lista
    public void removeScenario(Scenario scenario) {
        scenarioList.remove(scenario);
    }

    // Restituisce la lista di tutti gli scenari
    public List<Scenario> getAllScenarios() {
        return new ArrayList<>(scenarioList); // Ritorna una copia per evitare modifiche esterne non controllate
    }

    // Altri metodi utili possono essere aggiunti in base alle esigenze...
}

