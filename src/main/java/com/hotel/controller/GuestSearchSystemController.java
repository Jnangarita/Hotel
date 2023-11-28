package com.hotel.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.hotel.dao.GuestRegisterDao;
import com.hotel.enumerations.Routes;
import com.hotel.exception.KnownExceptions;
import com.hotel.factory.ConnectionFactory;
import com.hotel.model.Guest;
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
	private TableColumn<Guest, Date> columnBirthdate;

	@FXML
	private TableColumn<Guest, String> columnLastName;

	@FXML
	private TableColumn<Guest, String> columnName;

	@FXML
	private TableColumn<Guest, String> columnNationality;

	@FXML
	private TableColumn<Guest, String> columnPhone;

	@FXML
	private TableColumn<Guest, String> columnReservationCode;

	@FXML
	private TableView<Guest> tableGuest;

	@FXML
	private TextField txtSearch;

	private GuestRegisterDao guestRegisterDao;

	Commons commons = new Commons();

	public static final String GENERAL_LIST = "allGuests";

	public static final String PARAMETERIZED_LIST = "guestResult";

	public GuestSearchSystemController() throws IOException, SQLException {
		var factory = new ConnectionFactory();
		this.guestRegisterDao = new GuestRegisterDao(factory.createConnection());
	}

	public void initialize() {
		listGuests(GENERAL_LIST);
	}

	@FXML
	void deleteGuest(ActionEvent event) {
	}

	@FXML
	void editGuest(ActionEvent event) {
		Guest guest = tableGuest.getSelectionModel().getSelectedItem();
		System.out.println(guest);
	}

	@FXML
	void goToGuestScreen(ActionEvent event) {
	}

	@FXML
	void goToReservationScreen(ActionEvent event) {
		commons.openScreen(event, Routes.RESERVATION_SEARCH_SYSTEM.getPath());
	}

	@FXML
	void searchGuest(ActionEvent event) {
		if(txtSearch.getText().isEmpty()) {
			throw new KnownExceptions("El campo de búsqueda no puede ser vació");
		}
		listGuests(PARAMETERIZED_LIST);
	}

	public void listGuests(String listType) {
		ObservableList<Guest> listGuest = null;
		if(listType.equals(GENERAL_LIST)) {
			listGuest = FXCollections.observableArrayList(guestRegisterDao.guestList());
		}else if(listType.equals(PARAMETERIZED_LIST)) {
			listGuest = FXCollections.observableArrayList(guestRegisterDao.searchGuest(txtSearch.getText()));
		}
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		columnBirthdate.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
		columnNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
		columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		columnReservationCode.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
		tableGuest.setItems(listGuest);
	}
}