package com.hotel.controller;

import com.hotel.utils.Commons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

	Commons commons = new Commons();

	@FXML
	private Button closeBtn;

	@FXML
	private Button loginBtn;

	@FXML
	void closeApp(ActionEvent event) {
		commons.closeApplication();
	}

	@FXML
	void login(ActionEvent event) {
		String route = "/fxml/Login.fxml";
		commons.openScreen(event, route);
	}
}