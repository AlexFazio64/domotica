package com.orion.domotica;

import com.orion.domotica.Factory.BlindsFactory;
import com.orion.domotica.Factory.Factory;
import com.orion.domotica.Factory.LightFactory;
import com.orion.domotica.Factory.PlugFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class AddDeviceController {

    @FXML
    public VBox deviceBox;
    @FXML
    public TextField nameLbl;
    @FXML
    public TextField idLbl;
    @FXML
    public ToggleGroup type;
    @FXML
    public RadioButton ligthRad;
    @FXML
    public RadioButton plugRad;
    @FXML
    public RadioButton blindsRad;
    @FXML
    public Button addBtn;

    Factory factory = null;

    public void initialize() {
        System.out.println("AddDeviceController.initialize()");
    }

    public void newDevice(ActionEvent actionEvent) {
        System.out.println("AddDeviceController.newDevice()");

        String name = nameLbl.getText();
        String id = idLbl.getText();

        if (ligthRad.isSelected()) {
            factory = new LightFactory();
        } else if (plugRad.isSelected()) {
            factory = new PlugFactory();
        } else if (blindsRad.isSelected()) {
            factory = new BlindsFactory();
        }

        Main.domotica.addDevice(id, name, factory);
        Main.setScene("user_logged.fxml");
    }
}
