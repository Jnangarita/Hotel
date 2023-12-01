package com.hotel.enumerations;

public enum Routes {
	RESERVATION_SEARCH_SYSTEM("/fxml/ReservationSearchSystem.fxml"),
	REGISTER("/fxml/Register.fxml"),
	USER_MENU("/fxml/UserMenu.fxml"),
	GUEST_SEARCH_SYSTEM("/fxml/GuestSearchSystem.fxml"),
	LOGIN("/fxml/Login.fxml"),
	GUEST_REGISTER("/fxml/GuestRegister.fxml"),
	RESERVATION("/fxml/Reservation.fxml"),
	EDIT_GUEST("/fxml/EditGuest.fxml"),
	EDIT_RESERVATION("/fxml/EditReservation.fxml");

	private final String path;

	Routes(String path) {
        this.path = path;
    }

	public String getPath() {
		return path;
	}
}