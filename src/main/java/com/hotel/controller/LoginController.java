package com.hotel.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.hotel.dao.UserDao;
import com.hotel.exception.KnownExceptions;
import com.hotel.factory.ConnectionFactory;
import com.hotel.model.User;
import com.hotel.utils.Commons;
import com.hotel.utils.Util;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
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

    private UserDao userDao;

    Commons commons = new Commons();

    Util util = new Util();

    public LoginController() throws IOException, SQLException {
		var factory = new ConnectionFactory();
		this.userDao = new UserDao(factory.createConnection());
    }

    @FXML
    void closeApp(ActionEvent event) {
    	commons.closeApplication();
    }

    @FXML
    void goToMainScreen(ActionEvent event) throws NoSuchAlgorithmException {
    	String password = util.encryptPassword(txtPassword.getText());
    	if(txtUser.getText().isEmpty() || txtPassword.getText().isEmpty()) {
    		throw new KnownExceptions("Los campos no pueden ser vacíos");
    	}
    	User user = userDao.getUser(txtUser.getText(), password);
    	if(user != null) {
    		String route = "/fxml/UserMenu.fxml";
    		commons.openScreen(event, route);
    	}else {
    		System.out.println("Usuario y contraseña inválidos");
    		commons.clearTextField(txtUser, txtPassword);
    	}
    }

    @FXML
    void goToRegisterScreen(ActionEvent event) {
    	String route = "/fxml/Register.fxml";
		commons.openScreen(event, route);
    }
}