package com.hotel.utils;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.hotel.enumerations.Messages;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Commons {
	public static final String ERROR_TITLE = "Error";

	public void openScreen(ActionEvent event, String route) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(route));
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeApplication() {
		int answer = JOptionPane.showConfirmDialog(null, "¿Desea Salir de la Aplicación?", "Salir",
				JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			Platform.exit();
		}
	}

	public void clearTextField(TextField... fields) {
		for (TextField field : fields) {
			field.clear();
		}
	}

	public void showSuccessMessage(String idReservation) {
		JOptionPane.showMessageDialog(null, "Se ha registrado correctamente, el código de reserva es: " + idReservation,
				"Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
	}

	public void showErrorMessage() {
		JOptionPane.showMessageDialog(null, "Ocurrió un error en la reservación", ERROR_TITLE,
				JOptionPane.ERROR_MESSAGE);
	}

	public void showMessageEditSuccessful() {
		JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente", "Actualización exitosa",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageEditError() {
		JOptionPane.showMessageDialog(null, "Ocurrió un error en la actualización", ERROR_TITLE,
				JOptionPane.ERROR_MESSAGE);
	}

	public void showMessageDeleteSuccessful() {
		JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente", "Eliminar",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void showMessageDeleteError() {
		JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro", ERROR_TITLE,
				JOptionPane.ERROR_MESSAGE);
	}

	public void showNotificationEmptyField() {
		JOptionPane.showMessageDialog(null, Messages.EMPTY_FIELD.getSms(), "Campos Vacíos",
				JOptionPane.WARNING_MESSAGE);
	}

	public void showInvalidUserMessage() {
		JOptionPane.showMessageDialog(null, "Usuario y contraseña inválidos", "Usuario Invalido",
				JOptionPane.WARNING_MESSAGE);
	}
}