package com.orion.domotica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {
	private static Stage stage;
	public static Domotica domotica;

	public static void setScene(String s) {
		try {
			Scene scene = new Scene(FXMLLoader.load(Main.class.getResource(s)));
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		Main.stage = stage;
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		domotica = new Domotica();
		launch();
	}

	public static void saveToFile(String filename, String content) {
		// save the content to a file

		System.out.println("Saving to file: " + filename);
		System.out.println("Content: " + content);

		File file = new File(filename);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void loadFromFile(String filename) {
		// load the content from a file
		// the file contains the users information in the following format:
		// email;username;password;address;isAdmin

		System.out.println("Loading from file: " + filename);

		File file = new File(filename);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				if (!line.isEmpty()) {
					domotica.addUser(line);
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}