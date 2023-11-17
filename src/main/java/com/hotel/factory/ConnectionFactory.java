package com.hotel.factory;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    private String url;
    private String user;
    private String password;

    private FileConfig fileConfig = new FileConfig();

    public ConnectionFactory() throws IOException {
        Properties props = fileConfig.propertiesFile();
        this.url = props.getProperty("URL");
        this.user = props.getProperty("USER");
        this.password = props.getProperty("PASSWORD");
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.user, this.password);
    }
}