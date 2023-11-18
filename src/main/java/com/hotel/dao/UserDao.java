package com.hotel.dao;

import java.sql.*;

import com.hotel.exception.UnknownExceptions;
import com.hotel.model.User;

public class UserDao {
	private final Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

	public void saveUser(User user) {
		try {
			String querySave = "INSERT INTO login(userName, password) VALUES(?, ?)";
			final PreparedStatement statement = con.prepareStatement(querySave, Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				executeQueryToSave(user, statement);
			}
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar el usuario");
		}
	}

	private void executeQueryToSave(User user, PreparedStatement statement) {
		try {
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.execute();
			final ResultSet resultSet = statement.getGeneratedKeys();
			try (resultSet) {
				while (resultSet.next()) {
					user.setIdUser(resultSet.getInt(1));
					System.out.println("Inserto el usuario: " + user.toString());
				}
			}
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar el usuario");
		}
	}

	public User getUser(String userName, String password) {
		try {
			User userFound = null;
			String querySelect = "SELECT * FROM login WHERE userName = ? AND password = ?";
			final PreparedStatement statement = con.prepareStatement(querySelect);
			try (statement) {
				statement.setString(1, userName);
				statement.setString(2, password);
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					if (resultSet.next()) {
						userFound = new User(resultSet.getString("userName"), resultSet.getString("password"));
					}
				}
			}
			return userFound;
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de obtener el usuario");
		}
	}
}