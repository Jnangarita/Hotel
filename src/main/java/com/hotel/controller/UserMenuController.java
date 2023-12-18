package com.hotel.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.hotel.enumerations.Messages;
import com.hotel.enumerations.Routes;
import com.hotel.utils.Commons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserMenuController {

	@FXML
	private Button btnRegisterReservation;

	@FXML
	private Button btnSearch;

	@FXML
	private Button btnSignOff;

	@FXML
	private Label txtCurrentDate;

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
		int answer = JOptionPane.showConfirmDialog(null, Messages.LOG_OUT.getSms(), Messages.TITLE_LOG_OUT.getSms(),
				JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			commons.openScreen(event, Routes.LOGIN.getPath());
		}
	}

	@FXML
	void initialize() {
		Date currentDate = Date.valueOf(LocalDate.now());

		// formateador de fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

		// Convertir Date a String utilizando el formateador
		String formattedDate = dateFormat.format(currentDate);

		txtCurrentDate.setText(formattedDate);
	}
}