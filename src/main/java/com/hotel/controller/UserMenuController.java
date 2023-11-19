package com.hotel.controller;

import javax.swing.JOptionPane;

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
    	String route = "/fxml/Reservation.fxml";
    	commons.openScreen(event, route);
    }

    @FXML
    void goToSearchScreen(ActionEvent event) {
    	String route = "/fxml/SearchSystem.fxml";
    	commons.openScreen(event, route);
    }

    @FXML
    void signOff(ActionEvent event) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cerrar sesión",
				JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			String route = "/fxml/Login.fxml";
	    	commons.openScreen(event, route);
		}
    }
}