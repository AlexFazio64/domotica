package com.orion.domotica;

import com.orion.domotica.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserLoggedController {
	Button userBtn;
	Button deviceBtn;
	Button sceneBtn;
	Button actionBtn;

	@FXML
	BorderPane pane;

	BorderPane user;
	BorderPane devices;
	BorderPane scene;
	BorderPane actions;

	public void initialize() {
		System.out.println("UserLoggedController.initialize()");

		user = new BorderPane();
		user.getTop();

		HBox center = new HBox();
		VBox userinfo = new VBox();
		User usr = Main.domotica.getUser();
		ScrollPane childUsers = new ScrollPane(new VBox());

		userinfo.getChildren().add(new Label(usr.username));
		center.getChildren().add(userinfo);

		if (Main.domotica.isAdmin()) {
			Button add = new Button("Add User");
			add.setOnAction(e -> {
				Main.setScene("create_user.fxml");
			});
			user.setTop(add);
			userinfo.getChildren().add(new Label(usr.email));
			userinfo.getChildren().add(new Label(usr.addr));

			loadChildren(childUsers);
			center.getChildren().add(childUsers);
		} else {
			userinfo.getChildren().add(new Label(usr.ownerId + ""));
		}

		user.setCenter(center);
		user.setBottom(new Button("Logout"));

		devices = new BorderPane();
		scene = new BorderPane();
		actions = new BorderPane();

		pane.setCenter(user);
	}

	private void loadChildren(ScrollPane childUsers) {
		System.out.println("STO CARICANDO !");
		Main.domotica.getChildUsers().forEach(u -> {
			Label l = new Label();
			Image img = new Image(UserLoggedController.class.getResourceAsStream("img/user.png"));
			l.setGraphic(new ImageView(img));
			Button delete = new Button("Delete");
			VBox p = new VBox(l, new Label(u.username), delete);
			delete.setOnAction(e -> {
				Main.domotica.deleteUser(u);
				((VBox) childUsers.getContent()).getChildren().remove(p);
			});
			((VBox) childUsers.getContent()).getChildren().add(p);
		});
	}

	public void user(ActionEvent actionEvent) {
		pane.setCenter(user);
		User user = Main.domotica.umanager.getUser();
		System.out.println(user.getUserDetails());
	}

	public void device(ActionEvent actionEvent) {
		pane.setCenter(devices);
	}

	public void scene(ActionEvent actionEvent) {
		pane.setCenter(scene);
	}

	public void action(ActionEvent actionEvent) {
		pane.setCenter(actions);
	}
}
