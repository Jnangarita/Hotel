package com.hotel.enumerations;

public enum Messages {
	EMPTY_FIELD("Los campos no pueden ser vacíos"),
	NATIONALITY_ERROR_INVALID_SELECTION(
			"La nacionalidad proporcionada no coincide con los valores válidos. Asegúrate de seleccionar una nacionalidad válida de la lista proporcionada"),
	PAYMENT_METHOD_ERROR_INVALID_SELECTION(
			"El método de pago proporcionado no coincide con los valores válidos. Asegúrate de seleccionar un método de pago válido de la lista proporcionada"),
	CANCEL_GUEST_REGISTRATION("¿Desea cancelar el registro del huésped?"),
	TITLE_CANCEL("Cancelar"),
	REQUIRED_GUEST_SELECTION("No se ha seleccionado ningún huésped. Por favor, elija un huésped antes de continuar."),
	ERROR_UPDATE_GUES_INFORMATION("Ocurrió un error al tratar de actualizar la información del huésped"),
	EMPTY_SEARCH_FIELD("El campo de búsqueda no puede ser vació"),
	INVALID_CREDENTIALS("***** Usuario y contraseña inválidos *****"),
	CANCEL_RESERVATION("¿Desea cancelar la reservación?"),
	ERROR_RESERVATION("Ocurrió un error en la reservación"),
	VALUE_CONVERSION_PROBLEM("Error al convertir la cadena a número en el valor de la reserva"),
	RESERVATION_REQUIRED("No se ha seleccionado ninguna reservación. Por favor, elija una reservación antes de continuar."),
	ERROR_UPDATE_RESERVATION_INFORMATION("Ocurrió un error al tratar de actualizar la información de la reservación"),
	LOG_OUT("¿Desea cerrar sesión?"),
	TITLE_LOG_OUT("Cerrar sesión");

	private final String sms;

	Messages(String sms) {
		this.sms = sms;
	}

	public String getSms() {
		return sms;
	}
}