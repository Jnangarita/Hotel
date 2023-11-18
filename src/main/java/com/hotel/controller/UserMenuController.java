package com.hotel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserMenuController {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnRegisterReservation;

    @FXML
    private Button btnSearch;

    @FXML
    void close(ActionEvent event) {}

    @FXML
    void goToReservationScreen(ActionEvent event) {}

    @FXML
    void goToSearchScreen(ActionEvent event) {}
}