package com.hotel.dao;

import java.sql.*;

import com.hotel.exception.UnknownExceptions;

public class GuestRegisterDao {
	private final Connection con;

	public GuestRegisterDao(Connection con) {
		this.con = con;
	}

	public int getNumberOfGuestRows() {
		int numberRows = 0;
		try {
			String querySelect = "SELECT COUNT(*) AS totalRows FROM huespedes";
			final PreparedStatement statement = con.prepareStatement(querySelect);
			try (statement) {
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					if (resultSet.next()) {
						numberRows = resultSet.getInt("totalRows");
					}
				}
			}
			return numberRows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UnknownExceptions(
					"Ocurrió un error al tratar de obtener el número de filas de la tabla huespedes");
		}
	}
}