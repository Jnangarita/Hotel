package com.hotel.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.hotel.dao.ReservationDao;
import com.hotel.enumerations.Routes;
import com.hotel.exception.KnownExceptions;
import com.hotel.factory.ConnectionFactory;
import com.hotel.model.Reservation;
import com.hotel.utils.Commons;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private TableColumn<Reservation, Date> columnDateCheckIn;

	@FXML
	private TableColumn<Reservation, Date> columnDateCheckOut;

	@FXML
	private TableColumn<Reservation, String> columnPaymentMethod;

	@FXML
	private TableColumn<Reservation, Double> columnPrice;

	@FXML
	private TableColumn<Reservation, String> columnReservationCode;

	@FXML
	private TableView<Reservation> tableReservation;

	@FXML
	private TextField txtSearch;

	private ReservationDao reservationDao;

	Commons commons = new Commons();

	public static final String GENERAL_LIST = "allReservation";

	public static final String PARAMETERIZED_LIST = "reservationResult";

	public ReservationSearchSystemController() throws IOException, SQLException {
		var factory = new ConnectionFactory();
		this.reservationDao = new ReservationDao(factory.createConnection());
	}

	public void initialize() {
		listReservations(GENERAL_LIST);
	}

	@FXML
	void deleteReservation(ActionEvent event) {
	}

	@FXML
	void editReservation(ActionEvent event) {
	}

	@FXML
	void goToGuestScreen(ActionEvent event) {
		commons.openScreen(event, Routes.GUEST_SEARCH_SYSTEM.getPath());
	}

	@FXML
	void goToReservationScreen(ActionEvent event) {
	}

	@FXML
	void searchReservation(ActionEvent event) {
		if (txtSearch.getText().isEmpty()) {
			throw new KnownExceptions("El campo de búsqueda no puede ser vació");
		}
		listReservations(PARAMETERIZED_LIST);
	}

	public void listReservations(String listType) {
		ObservableList<Reservation> listReservations = null;
		if (listType.equals(GENERAL_LIST)) {
			listReservations = FXCollections.observableArrayList(reservationDao.reservationList());
		} else if (listType.equals(PARAMETERIZED_LIST)) {
			listReservations = FXCollections.observableArrayList(reservationDao.searchReservation(txtSearch.getText()));
		}
		columnReservationCode.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
		columnDateCheckIn.setCellValueFactory(new PropertyValueFactory<>("dateCheckIn"));
		columnDateCheckOut.setCellValueFactory(new PropertyValueFactory<>("dateCheckOut"));
		columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		columnPaymentMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
		tableReservation.setItems(listReservations);
	}
}