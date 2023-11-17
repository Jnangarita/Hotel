package com.hotel.controller;

import com.hotel.utils.Commons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

	Commons commons = new Commons();

    @FXML
    private Button closeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    void closeApp(ActionEvent event) {
    	commons.closeApplication();
    }

    @FXML
    void goToMainScreen(ActionEvent event) {}

    @FXML
    void goToRegisterScreen(ActionEvent event) {
    	String route = "/fxml/Register.fxml";
		commons.openScreen(event, route);
    }
}