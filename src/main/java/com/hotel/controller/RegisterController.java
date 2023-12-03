package com.hotel.controller;

import java.security.NoSuchAlgorithmException;

import com.hotel.dao.UserDao;
import com.hotel.factory.ConnectionFactory;
import com.hotel.model.User;
import com.hotel.utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {
	@FXML
	private Button closeBtn;

	@FXML
	private Button registerBtn;

	@FXML
	private PasswordField txtConfirmPassword;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtUser;

	private UserDao userDao;

	Commons commons = new Commons();

	Util util = new Util();

	public RegisterController() {
		var factory = new ConnectionFactory();
		this.userDao = new UserDao(factory.createConnection());
	}

	@FXML
	void closeApp(ActionEvent event) {
		commons.closeApplication();
	}

	@FXML
	public void saveNewUser(ActionEvent event) {
		try {
			if(txtPassword.getText().isEmpty() || txtConfirmPassword.getText().isEmpty()) {
				commons.showNotificationEmptyField();
				return;
			}
			String password = util.encryptPassword(txtPassword.getText());
			String confirmPassword = util.encryptPassword(txtConfirmPassword.getText());
			if(password.equals(confirmPassword)) {
				User user = new User(txtUser.getText(), password);
				userDao.saveUser(user);
				commons.clearTextField(txtUser, txtPassword, txtConfirmPassword);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}