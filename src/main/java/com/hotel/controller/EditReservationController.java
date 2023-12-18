package com.hotel.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.hotel.dao.ReservationDao;
import com.hotel.enumerations.Messages;
import com.hotel.enumerations.PaymentMethod;
import com.hotel.enumerations.Routes;
import com.hotel.exception.KnownExceptions;
import com.hotel.factory.ConnectionFactory;
import com.hotel.model.Reservation;
import com.hotel.utils.Commons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EditReservationController {

	@FXML
	private Button btnEdit;

	@FXML
	private ComboBox<PaymentMethod> comboPaymentMethod;

	@FXML
	private DatePicker dpDateCheckIn;

	@FXML
	private DatePicker dpDateCheckOut;

	@FXML
	private TextField txtReservationPrice;

	@FXML
	private Reservation reservationController;

	private ReservationDao reservationDao;

	Commons commons = new Commons();

	private static final Logger logger = Logger.getLogger(EditReservationController.class.getName());

	public EditReservationController() {
		var factory = new ConnectionFactory();
		this.reservationDao = new ReservationDao(factory.createConnection());
	}

	@FXML
	void editReservation(ActionEvent event) {
		int result = 0;
		if (dpDateCheckIn.getValue() == null && dpDateCheckOut.getValue() == null
				&& !txtReservationPrice.getText().isEmpty() && comboPaymentMethod.getValue() == null) {
			throw new KnownExceptions(Messages.EMPTY_FIELD.getSms());
		}
		Date initialDate = Date.valueOf(dpDateCheckIn.getValue());
		Date finalDate = Date.valueOf(dpDateCheckOut.getValue());
		Reservation reservation = new Reservation(this.reservationController.getId(), initialDate, finalDate,
				Double.parseDouble(txtReservationPrice.getText()), comboPaymentMethod.getValue().toString());
		result = reservationDao.editReservation(reservation);
		if (result > 0) {
			commons.showMessageEditSuccessful();
			commons.openScreen(event, Routes.RESERVATION_SEARCH_SYSTEM.getPath());
		} else {
			commons.showMessageEditError();
		}
	}

	public void setReservation(Reservation reservation) {
		this.reservationController = reservation;
		try {
			txtReservationPrice.setText(String.valueOf(reservation.getPrice()));
			dpDateCheckIn.setValue(reservation.getDateCheckIn().toLocalDate());
			dpDateCheckOut.setValue(reservation.getDateCheckOut().toLocalDate());
			comboPaymentMethod.setValue(PaymentMethod.valueOf(reservation.getPaymentMethod()));
		} catch (IllegalArgumentException e) {
			logger.warning(Messages.PAYMENT_METHOD_ERROR_INVALID_SELECTION.getSms());
		}
	}

	@FXML
	void initialize() {
		List<PaymentMethod> listPaymentMethod = Arrays.asList(PaymentMethod.values());
		comboPaymentMethod.getItems().addAll(listPaymentMethod);
	}
}