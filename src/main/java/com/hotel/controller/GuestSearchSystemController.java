package com.hotel.controller;

import com.hotel.utils.Commons;
import com.hotel.enumerations.Routes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GuestSearchSystemController {

    @FXML
    private Button btnDeleteGuest;

    @FXML
    private Button btnEditGuest;

    @FXML
    private Button btnGuest;

    @FXML
    private Button btnReservation;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<?> tableGuest;

    @FXML
    private TextField txtSearch;

    Commons commons = new Commons();

    @FXML
    void deleteGuest(ActionEvent event) {}

    @FXML
    void editGuest(ActionEvent event) {}

    @FXML
    void goToGuestScreen(ActionEvent event) {}

    @FXML
    void goToReservationScreen(ActionEvent event) {
    	commons.openScreen(event, Routes.RESERVATION_SEARCH_SYSTEM.getPath());
    }

    @FXML
    void searchGuest(ActionEvent event) {}
}