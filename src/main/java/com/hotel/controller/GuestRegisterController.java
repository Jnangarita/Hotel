package com.hotel.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.hotel.dao.GuestRegisterDao;
import com.hotel.dao.ReservationDao;
import com.hotel.enumerations.Nationality;
import com.hotel.factory.ConnectionFactory;
import com.hotel.model.Guest;
import com.hotel.model.Reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GuestRegisterController {

	@FXML
	private Button btnSaveGuestRecord;

	@FXML
	private ComboBox<Nationality> comboNationality;

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
	private Reservation reservationController;

	private ReservationDao reservationDao;

	private GuestRegisterDao guestRegisterDao;

	public void setReservationController(Reservation reservation) {
		this.reservationController = reservation;
	}

	public GuestRegisterController() throws IOException, SQLException {
		var factory = new ConnectionFactory();
		this.reservationDao = new ReservationDao(factory.createConnection());
		this.guestRegisterDao = new GuestRegisterDao(factory.createConnection());
	}

	@FXML
	void saveGuestRecord(ActionEvent event) {
		boolean registrationResult = false;
		String name = txtName.getText();
		String lastName = txtLastName.getText();
		LocalDate date = dpBirthdate.getValue();
		Date dpBirthdate = Date.valueOf(date);
		String nationality = comboNationality.getValue().toString();
		String phone = txtPhone.getText();
		String idReservation = this.reservationController.getIdReservation();
		Guest guest = new Guest(name, lastName, dpBirthdate, nationality, phone, idReservation);
		registrationResult = guestRegisterDao.saveGuest(guest);
		if(registrationResult) {
			reservationDao.saveReservation(reservationController);
		}
	}

	@FXML
	void initialize() {
		List<Nationality> listPaymentMethods = Arrays.asList(Nationality.values());
		comboNationality.getItems().addAll(listPaymentMethods);
	}
}