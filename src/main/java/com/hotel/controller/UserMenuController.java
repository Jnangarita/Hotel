package com.hotel.controller;

import javax.swing.JOptionPane;

import com.hotel.enumerations.Routes;
import com.hotel.utils.Commons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserMenuController {

	@FXML
	private Button btnRegisterReservation;

	@FXML
	private Button btnSearch;

	@FXML
	private Button btnSignOff;

	Commons commons = new Commons();

	@FXML
	void goToReservationScreen(ActionEvent event) {
		commons.openScreen(event, Routes.RESERVATION.getPath());
	}

	@FXML
	void goToSearchScreen(ActionEvent event) {
		commons.openScreen(event, Routes.GUEST_SEARCH_SYSTEM.getPath());
	}

	@FXML
	void signOff(ActionEvent event) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cerrar sesión",
				JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			commons.openScreen(event, Routes.LOGIN.getPath());
		}
	}
}