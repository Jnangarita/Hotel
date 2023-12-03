package com.hotel.factory;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

import com.hotel.exception.KnownExceptions;

public class ConnectionFactory {
	private String url;
	private String user;
	private String password;

	private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

	private FileConfig fileConfig = new FileConfig();

	public ConnectionFactory() {
		Properties props = fileConfig.propertiesFile();
		this.url = props.getProperty("URL");
		this.user = props.getProperty("USER");
		this.password = props.getProperty("PASSWORD");
	}

	public Connection createConnection() {
		try {
			return DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			logger.warning(
					"Error al obtener las credenciales de la DB. Asegúrate de que el archivo config.properties esté presente y las credenciales sean válidas");
			throw new KnownExceptions("Clase: ConnectionFactory " + e.getMessage());
		}
	}
}