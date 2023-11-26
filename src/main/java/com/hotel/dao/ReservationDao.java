package com.hotel.dao;

import java.sql.*;
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
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar la reserva");
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
					logger.info("***** La reservación se ha registrado correctamente *****");
					result = true;
				}
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UnknownExceptions("Ocurrió un error al tratar de registrar la reserva");
		}
	}
}