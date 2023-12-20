package com.orion.domotica;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import com.orion.domotica.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CreateUserController {
    @FXML
    VBox devicesBox;
    @FXML
    TextField userTxt;
    @FXML
    PasswordField passTxt;
    @FXML
    Button regBtn;

    public void initialize() {
        System.out.println("CreateUserController.initialize()");
    }

    public void register(ActionEvent actionEvent) {
        User user = new User(userTxt.getText(), passTxt.getText(), Main.domotica.getUser().userId);
        Main.domotica.saveUser(user);
        Main.domotica.addUser(user.toString());
        Main.setScene("user_logged.fxml");
    }
}
