package com.hotel.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileConfig {
    public Properties propertiesFile() throws IOException {
        Properties properties = new Properties();
        // getResourceAsStream carga el archivo desde el directorio de recursos
        InputStream file = getClass().getResourceAsStream("/config.properties");
        properties.load(file);
        return properties;
    }
}