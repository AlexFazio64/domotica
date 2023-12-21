package com.orion.domotica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	Button regBtn;
	@FXML
	Button logBtn;
	@FXML
	TextField userTxt;
	@FXML
	PasswordField passTxt;

	public void initialize() {
		userTxt.setText("admin");
		passTxt.setText("admin");
	}

	public void login(ActionEvent actionEvent) {
		Main.loadUser(LoginController.class.getResource("users/users.txt").getPath());
		Main.loadDevice(UserLoggedController.class.getResource("devices/devices.txt").getPath());

		Main.domotica.login(userTxt.getText(), passTxt.getText());
	}

	public void register(ActionEvent actionEvent) {
		Main.setScene("register.fxml");
	}
}