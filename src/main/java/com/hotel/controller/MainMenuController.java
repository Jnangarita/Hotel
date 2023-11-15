package com.hotel.controller;

import javax.swing.JOptionPane;

import com.hotel.utils.Commons;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

	@FXML
	private Button closeBtn;

	@FXML
	private Button loginBtn;

	@FXML
	void closeApp(ActionEvent event) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Desea Salir de la Aplicación?", "Salir",
				JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			Platform.exit();
		}
	}

	@FXML
	void login(ActionEvent event) {
		Commons commons = new Commons();
		String route = "/fxml/HolaMundo.fxml";
		commons.openScreen(event, route);
	}
}