package com.hotel.controller;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import com.hotel.dao.UserDao;
import com.hotel.enumerations.Messages;
import com.hotel.enumerations.Routes;
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

	private static final Logger logger = Logger.getLogger(LoginController.class.getName());

	public LoginController() {
		var factory = new ConnectionFactory();
		this.userDao = new UserDao(factory.createConnection());
	}

	@FXML
	void closeApp(ActionEvent event) {
		commons.closeApplication();
	}

	@FXML
	void goToMainScreen(ActionEvent event) throws NoSuchAlgorithmException {
		if (txtUser.getText().isEmpty() || txtPassword.getText().isEmpty()) {
			commons.showNotificationEmptyField();
			return;
		}
		String password = util.encryptPassword(txtPassword.getText());
		User user = userDao.getUser(txtUser.getText(), password);
		if (user != null) {
			commons.openScreen(event, Routes.USER_MENU.getPath());
		} else {
			commons.showInvalidUserMessage();
			logger.warning(Messages.INVALID_CREDENTIALS.getSms());
			commons.clearTextField(txtUser, txtPassword);
		}
	}

	@FXML
	void goToRegisterScreen(ActionEvent event) {
		commons.openScreen(event, Routes.REGISTER.getPath());
	}
}