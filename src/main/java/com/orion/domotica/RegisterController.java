package com.orion.domotica;

import com.orion.domotica.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    Button regBtn;
    @FXML
    TextField emailTxt;
    @FXML
    TextField userTxt;
    @FXML
    TextField addrTxt;
    @FXML
    PasswordField passTxt;

    public void initialize() {
        System.out.println("RegisterController.initialize()");
    }

    public void register(ActionEvent actionEvent) {
        User user = Main.domotica.createUser(emailTxt.getText(), userTxt.getText(), passTxt.getText(), addrTxt.getText());
        Main.domotica.saveUser(user);
        Main.domotica.addUser(user.toString());
        Main.setScene("login.fxml");
    }
}
