package com.orion.domotica;

import com.orion.domotica.device.Device;
import com.orion.domotica.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
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

		setUserPane();

		setDevicePane();
		scene = new BorderPane();
		actions = new BorderPane();

		pane.setCenter(user);

		Button logout = new Button("Logout");
		logout.setOnAction(e -> {
			Main.domotica.logout();
			Main.setScene("login.fxml");
		});

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.getChildren().add(logout);

		pane.setBottom(bottom);
	}

	private void setDevicePane() {
		devices = new BorderPane();

		Accordion accordion = new Accordion();
		TitledPane light = new TitledPane("Lights", new VBox());
		TitledPane plug = new TitledPane("Plugs", new VBox());
		TitledPane blinds = new TitledPane("Blinds", new VBox());

		accordion.getPanes().addAll(light, plug, blinds);
		light.setExpanded(true);

		Button add = new Button("Add Device");
		add.setOnAction(e -> {
			Main.setScene("add_devices.fxml");
		});

		Main.domotica.dmanager.getAllDevices().forEach(d -> {
			if (d.getClass().getSimpleName().contains("Light")) {
				CreateDeviceGraphics(light, d, "light", true, true);
			} else if (d.getClass().getSimpleName().contains("Plug")) {
				CreateDeviceGraphics(plug, d, "plug", false, true);
			} else if (d.getClass().getSimpleName().contains("Blinds")) {
				CreateDeviceGraphics(blinds, d, "blinds", true, false);
			}
		});

		HBox addBox = new HBox(add);
		addBox.setAlignment(Pos.CENTER);

		devices.setCenter(accordion);
		devices.setBottom(addBox);
	}

	private void CreateDeviceGraphics(TitledPane pane, Device device, String name, boolean... args) {
		HBox devBox = new HBox();
		devBox.setAlignment(Pos.CENTER);
		Label l = new Label();
		Image img = new Image(UserLoggedController.class.getResourceAsStream("img/" + name + ".png"));
		l.setGraphic(new ImageView(img));
		devBox.getChildren().add(l);

		VBox devInfo = new VBox();
		devInfo.getChildren().add(new Label(device.getDeviceName()));
		devInfo.getChildren().add(new Label(device.getDeviceId()));

		devBox.getChildren().add(devInfo);

		VBox devSettings = new VBox();

		Slider brightness = new Slider(0, 100, 1);
		CheckBox power = new CheckBox("Power");
		Button apply = new Button("Apply");

		if (args[0]) {
			devSettings.getChildren().add(brightness);
		}
		if (args[1]) {
			devSettings.getChildren().add(power);
		}

		devSettings.getChildren().add(apply);

		devBox.getChildren().add(devSettings);

		((VBox) pane.getContent()).getChildren().add(devBox);
	}

	private void setUserPane() {
		user = new BorderPane();

		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);
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
