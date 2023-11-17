package com.hotel.dao;

import java.sql.*;

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
			throw new RuntimeException(e);
		}
	}

	private void executeQueryToSave(User user, PreparedStatement statement)
			throws SQLException {
		statement.setString(1, user.getUserName());
    	statement.setString(2, user.getPassword());
    	statement.execute();
    	final ResultSet resultSet = statement.getGeneratedKeys();
    	try(resultSet){
        	while (resultSet.next()) {
        		user.setIdUser(resultSet.getInt(1));
        		System.out.println("Inserto el usuario: " + user.toString());
        	}
    	}
	}
}