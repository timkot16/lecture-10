package by.itacademy.javaenterpise.kotkovski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionWithPropertiesFile {

    private final Logger logger = LoggerFactory.getLogger(ConnectionWithPropertiesFile.class);

    Properties properties = new Properties();
    String DBPropertiesPath = "src/main/resources/db.properties";

    {
        try (FileInputStream fileInputStream = new FileInputStream(DBPropertiesPath)) {
            properties.load(fileInputStream);
            logger.info("File loaded {}", DBPropertiesPath);
        } catch (IOException e) {
            logger.error("Failed to load file {}", DBPropertiesPath, e);
        }
    }

    private final String jdbc_driver = properties.getProperty("JDBC_DRIVER");
    private final String database_url = properties.getProperty("DATABASE_URL");
    private final String user = properties.getProperty("USER");
    private final String password = properties.getProperty("PASSWORD");

    private Connection connection;

    public ConnectionWithPropertiesFile() {
        try {
            Class.forName(jdbc_driver);
            logger.info("Connection with JDBC_DRIVER {}", jdbc_driver);
        } catch (ClassNotFoundException e) {
            logger.error("Failed to connect with JDBC_DRIVER {}", jdbc_driver, e);
        }

        try {
            connection = DriverManager.getConnection(database_url, user, password);
            logger.info("Connection with DATABASE_URL {}", database_url);
        } catch (SQLException e) {
            logger.error("Failed to connect with DATABASE_URL {}", database_url, e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
