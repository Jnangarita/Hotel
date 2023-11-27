package com.hotel.controller;

import com.hotel.enumerations.Routes;
import com.hotel.utils.Commons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReservationSearchSystemController {

    @FXML
    private Button btnDeleteReservation;

    @FXML
    private Button btnEditReservation;

    @FXML
    private Button btnGuest;

    @FXML
    private Button btnReservation;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<?> tableReservation;

    @FXML
    private TextField txtSearch;

    Commons commons = new Commons();

    @FXML
    void deleteReservation(ActionEvent event) {}

    @FXML
    void editReservation(ActionEvent event) {}

    @FXML
    void goToGuestScreen(ActionEvent event) {
    	commons.openScreen(event, Routes.GUEST_SEARCH_SYSTEM.getPath());
    }

    @FXML
    void goToReservationScreen(ActionEvent event) {}

    @FXML
    void searchReservation(ActionEvent event) {}
}