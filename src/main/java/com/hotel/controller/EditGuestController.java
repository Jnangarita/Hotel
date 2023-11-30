package com.hotel.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.hotel.dao.GuestRegisterDao;
import com.hotel.enumerations.Nationality;
import com.hotel.enumerations.Routes;
import com.hotel.exception.KnownExceptions;
import com.hotel.factory.ConnectionFactory;
import com.hotel.model.Guest;
import com.hotel.utils.Commons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EditGuestController {

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
	private Guest guestController;

	private GuestRegisterDao guestRegisterDao;

	Commons commons = new Commons();

	public EditGuestController() throws IOException, SQLException {
		var factory = new ConnectionFactory();
		this.guestRegisterDao = new GuestRegisterDao(factory.createConnection());
	}

	@FXML
	void saveGuestRecord(ActionEvent event) {
		int result = 0;
		if (txtName.getText().isEmpty() || txtLastName.getText().isEmpty() || dpBirthdate.getValue() == null
				|| comboNationality.getValue().toString().isEmpty() || txtPhone.getText().isEmpty()) {
			throw new KnownExceptions("Los campos no pueden ser vacíos");
		}
		LocalDate date = dpBirthdate.getValue();
		Date birthdate = Date.valueOf(date);
		Guest guest = new Guest(this.guestController.getId(), txtName.getText(), txtLastName.getText(), birthdate,
				comboNationality.getValue().toString(), txtPhone.getText());
		result = guestRegisterDao.editGuest(guest);
		if (result > 0) {
			commons.showMessageEditSuccessful();
			commons.openScreen(event, Routes.GUEST_SEARCH_SYSTEM.getPath());
		} else {
			commons.showMessageEditError();
		}
	}

	public void setGuest(Guest guest) {
		this.guestController = guest;
		try {
			txtName.setText(guest.getName());
			txtLastName.setText(guest.getLastName());
			Date date = guest.getBirthdate();
			LocalDate localDate = date.toLocalDate();
			dpBirthdate.setValue(localDate);
			comboNationality.setValue(Nationality.valueOf(guest.getNationality()));
			txtPhone.setText(guest.getPhone());
			txtReservationNumber.setText(guest.getIdReservation());
		} catch (IllegalArgumentException e) {
			throw new KnownExceptions(
					"La nacionalidad proporcionada no coincide con los valores válidos. Asegúrate de seleccionar una nacionalidad válida de la lista proporcionada");
		}
	}

	@FXML
	void initialize() {
		List<Nationality> listPaymentMethods = Arrays.asList(Nationality.values());
		comboNationality.getItems().addAll(listPaymentMethods);
	}
}