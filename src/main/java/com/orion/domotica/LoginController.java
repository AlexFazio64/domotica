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
		Main.loadFromFile(LoginController.class.getResource("users/users.txt").getPath());
		userTxt.setText("admin");
		passTxt.setText("root");
	}

	public void login(ActionEvent actionEvent) {
		Main.domotica.login(userTxt.getText(), passTxt.getText());
	}

	public void register(ActionEvent actionEvent) {
		Main.setScene("register.fxml");
	}
}