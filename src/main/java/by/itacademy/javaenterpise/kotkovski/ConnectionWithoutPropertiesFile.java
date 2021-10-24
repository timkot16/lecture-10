package by.itacademy.javaenterpise.kotkovski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class ConnectionWithoutPropertiesFile {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/car_service";

    static final String USER = "root";
    static final String PASSWORD = "secret";

    private static final Logger logger = LoggerFactory.getLogger(ConnectionWithoutPropertiesFile.class);

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            logger.info("Connection with JDBC_DRIVER {}", JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("Failed to connect with JDBC_DRIVER {}", JDBC_DRIVER, e);
        }

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            logger.info("Connection with DATABASE_URL {}", DATABASE_URL);
        } catch (SQLException e) {
            logger.error("Failed to connect with DATABASE_URL {}", DATABASE_URL, e);
        }

        try {
            statement = connection.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);

            System.out.println("Creating statement...");

            String query = "SELECT * FROM Cars";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Full list of records:");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String car = resultSet.getString("car");
                String vin = resultSet.getString("vin");
                String number = resultSet.getString("number");
                int year = resultSet.getInt("year");
                int customer_id = resultSet.getInt("customer_id");

                System.out.println("id: " + id);
                System.out.println("car: " + car);
                System.out.println("vin: " + vin);
                System.out.println("number: " + number);
                System.out.println("year: " + year);
                System.out.println("customer_id: " + customer_id);
                System.out.println("\n=========================\n");
            }
        } catch (SQLException e) {
            logger.error("Failed with Statement or ResultSet", e);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    logger.info("Statement is closed.");
                } catch (SQLException e) {
                    logger.error("Failed to close Statement", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    logger.info("Connection is closed.");
                } catch (SQLException e) {
                    logger.error("Failed to close Connection", e);
                }
            }
        }
    }
}
