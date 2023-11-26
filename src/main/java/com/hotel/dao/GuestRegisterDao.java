package com.hotel.dao;

import java.sql.*;
import java.util.logging.Logger;

import com.hotel.exception.UnknownExceptions;
import com.hotel.model.Guest;

public class GuestRegisterDao {
	private final Connection con;

	private static final Logger logger = Logger.getLogger(GuestRegisterDao.class.getName());

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

	public boolean saveGuest(Guest guest) {
		boolean registrationResult = false;
		try {
			String querySave = "INSERT INTO huespedes (nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reserva)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			final PreparedStatement statement = con.prepareStatement(querySave, Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				registrationResult = executeQueryToSave(guest, statement);
			}
			return registrationResult;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar la reserva");
		}
	}

	private boolean executeQueryToSave(Guest guest, PreparedStatement statement) {
		boolean registrationResult = false;
		try {
			statement.setString(1, guest.getName());
			statement.setString(2, guest.getLastName());
			statement.setDate(3, guest.getBirthdate());
			statement.setString(4, guest.getNationality());
			statement.setString(5, guest.getPhone());
			statement.setString(6, guest.getIdReservation());
			statement.execute();
			final ResultSet resultSet = statement.getGeneratedKeys();
			try (resultSet) {
				while (resultSet.next()) {
					guest.setId(resultSet.getInt(1));
					logger.info("***** El huésped se ha registrado correctamente *****");
					registrationResult = true;
				}
			}
			return registrationResult;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar el huésped");
		}
	}
}