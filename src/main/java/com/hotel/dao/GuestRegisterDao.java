package com.hotel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
					"Ocurrió un error al tratar de obtener el número de filas de la tabla huéspedes");
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
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar al huésped");
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
					registrationResult = true;
					logger.info("***** El huésped se ha registrado correctamente *****");
				}
			}
			return registrationResult;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar el huésped");
		}
	}

	public List<Guest> guestList() {
		List<Guest> result = new ArrayList<>();
		try {
			String querySelect = "SELECT * FROM huespedes";
			final PreparedStatement statement = con.prepareStatement(querySelect);
			try (statement) {
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						Guest guest = new Guest(resultSet.getInt("id"), resultSet.getString("nombre"),
								resultSet.getString("apellido"), resultSet.getDate("fecha_de_nacimiento"),
								resultSet.getString("nacionalidad"), resultSet.getString("telefono"),
								resultSet.getString("id_reserva"));
						result.add(guest);
					}
					if (!result.isEmpty()) {
						logger.info("***** ¡Consulta exitosa! Tabla: huespedes *****");
					} else {
						logger.warning("***** Error en la consulta. Tabla: huespedes *****");
					}
				}
			}
			return result;
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de obtener los datos de la tabla huespedes");
		}
	}

	public List<Guest> searchGuest(String lastName) {
		List<Guest> result = new ArrayList<>();
		try {
			String querySelect = "SELECT * FROM huespedes WHERE apellido = ?";
			final PreparedStatement statement = con.prepareStatement(querySelect);
			try (statement) {
				statement.setString(1, lastName);
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						Guest guest = new Guest(resultSet.getString("nombre"), resultSet.getString("apellido"),
								resultSet.getDate("fecha_de_nacimiento"), resultSet.getString("nacionalidad"),
								resultSet.getString("telefono"), resultSet.getString("id_reserva"));
						result.add(guest);
					}
					if (!result.isEmpty()) {
						logger.info("***** ¡Búsqueda exitosa! Se encontraron resultados en la tabla huespedes. *****");
					} else {
						logger.warning(
								"***** No se encontraron resultados para la búsqueda en la tabla huespedes. *****");
					}
				}
			}
			return result;
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de buscar en la tabla huespedes");
		}
	}
}