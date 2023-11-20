package com.hotel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GuestRegisterController {

    @FXML
    private Button btnSaveGuestRecord;

    @FXML
    private ComboBox<?> comboNationality;

    @FXML
    private DatePicker dpBirthdate;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtReservationNumber;

    @FXML
    private ReservationController reservationController;

    public void setReservationController(ReservationController reservationController) {
        this.reservationController = reservationController;
    }

    @FXML
    void saveGuestRecord(ActionEvent event) {}
}