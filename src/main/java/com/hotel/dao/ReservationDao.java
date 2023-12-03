package com.hotel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.hotel.exception.UnknownExceptions;
import com.hotel.model.Reservation;

public class ReservationDao {
	private final Connection con;

	private static final Logger logger = Logger.getLogger(ReservationDao.class.getName());

	public ReservationDao(Connection con) {
		this.con = con;
	}

	public boolean saveReservation(Reservation reservation) {
		boolean result = false;
		try {
			String querySave = "INSERT INTO reservas (id_reserva, fecha_entrada, fecha_salida, valor, forma_pago)"
					+ " VALUES (?, ?, ?, ?, ?)";
			final PreparedStatement statement = con.prepareStatement(querySave, Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				result = executeQueryToSave(reservation, statement);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar la reserva.");
		}
	}

	private boolean executeQueryToSave(Reservation reservation, PreparedStatement statement) {
		boolean result = false;
		try {
			statement.setString(1, reservation.getIdReservation());
			statement.setDate(2, reservation.getDateCheckIn());
			statement.setDate(3, reservation.getDateCheckOut());
			statement.setDouble(4, reservation.getPrice());
			statement.setString(5, reservation.getPaymentMethod());
			statement.execute();
			final ResultSet resultSet = statement.getGeneratedKeys();
			try (resultSet) {
				while (resultSet.next()) {
					reservation.setId(resultSet.getInt(1));
					logger.info("***** La reservación se ha registrado correctamente. *****");
					result = true;
				}
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar la reserva.");
		}
	}

	public List<Reservation> reservationList() {
		List<Reservation> result = new ArrayList<>();
		try {
			String querySelect = "SELECT * FROM reservas";
			final PreparedStatement statement = con.prepareStatement(querySelect);
			try (statement) {
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						Reservation reservation = new Reservation(resultSet.getInt("id"),
								resultSet.getString("id_reserva"), resultSet.getDate("fecha_entrada"),
								resultSet.getDate("fecha_salida"), resultSet.getDouble("valor"),
								resultSet.getString("forma_pago"));
						result.add(reservation);
					}
					if (!result.isEmpty()) {
						logger.info("***** ¡Consulta exitosa! Tabla: reservas *****");
					} else {
						logger.warning("***** Tabla: reservas no tiene datos *****");
					}
				}
			}
			return result;
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de obtener los datos de la tabla reservas.");
		}
	}

	public List<Reservation> searchReservation(String idReservation) {
		List<Reservation> result = new ArrayList<>();
		try {
			String querySelect = "SELECT * FROM reservas WHERE id_reserva = ?";
			final PreparedStatement statement = con.prepareStatement(querySelect);
			try (statement) {
				statement.setString(1, idReservation);
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						Reservation reservation = new Reservation(resultSet.getString("id_reserva"),
								resultSet.getDate("fecha_entrada"), resultSet.getDate("fecha_salida"),
								resultSet.getDouble("valor"), resultSet.getString("forma_pago"));
						result.add(reservation);
					}
					if (!result.isEmpty()) {
						logger.info("***** ¡Búsqueda exitosa! Se encontraron resultados en la tabla reservas. *****");
					} else {
						logger.warning(
								"***** No se encontraron resultados para la búsqueda en la tabla reservas. *****");
					}
				}
			}
			return result;
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de buscar en la tabla reservas.");
		}
	}

	public int editReservation(Reservation reservation) {
		String queryUpdate = "UPDATE reservas SET fecha_entrada = ?, fecha_salida = ?, valor = ?, forma_pago = ? WHERE id = ?";
		try {
			PreparedStatement statement = con.prepareStatement(queryUpdate);
			try (statement) {
				statement.setDate(1, reservation.getDateCheckIn());
				statement.setDate(2, reservation.getDateCheckOut());
				statement.setDouble(3, reservation.getPrice());
				statement.setString(4, reservation.getPaymentMethod());
				statement.setInt(5, reservation.getId());
				statement.execute();
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de editar la reservación");
		}
	}

	public int deleteReservation(int id) {
		String queryDelete = "DELETE FROM reservas WHERE id = ?";
		try {
			final PreparedStatement statement = con.prepareStatement(queryDelete);
			try (statement) {
				statement.setInt(1, id);
				statement.execute();
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new UnknownExceptions("Ocurrió un error al tratar de eliminar la reservación " + e);
		}
	}
}