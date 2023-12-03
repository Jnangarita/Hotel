package com.hotel.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import com.hotel.enumerations.Routes;
import com.hotel.exception.KnownExceptions;

public class FileConfig {
	private static final Logger logger = Logger.getLogger(FileConfig.class.getName());

	public Properties propertiesFile() {
		try {
			Properties properties = new Properties();
			// getResourceAsStream carga el archivo desde el directorio de recursos
			InputStream file = getClass().getResourceAsStream(Routes.CONFIG_PROPERTIES.getPath());
			properties.load(file);
			return properties;
		} catch (NullPointerException e) {
			logger.warning("El objeto " + Routes.CONFIG_PROPERTIES.getPath() + " es null");
			throw new KnownExceptions("Clase: FileConfig " + e.getMessage());
		} catch (IOException e) {
			throw new KnownExceptions("Error al leer el archivo config.properties " + e.getMessage());
		}
	}
}