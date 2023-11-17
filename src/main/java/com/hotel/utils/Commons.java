package com.hotel.utils;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Commons {
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
}