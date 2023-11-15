package com.hotel.quilla;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
			Scene scene = new Scene(root, 750, 510);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hotel Quilla");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}