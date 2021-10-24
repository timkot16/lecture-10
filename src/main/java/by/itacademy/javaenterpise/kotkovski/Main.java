package by.itacademy.javaenterpise.kotkovski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ConnectionWithPropertiesFile connection = new ConnectionWithPropertiesFile();
        SQLCommands commands = new SQLCommands();

        try (Statement statement = connection.getConnection().createStatement()) {
            logger.info("Statement is created");

//            ResultSet resultSet = statement.executeQuery(commands.showCustomerTable());
//            while (resultSet.next()) {
//                System.out.print(resultSet.getInt("id")
//                        + " " + resultSet.getString("first_name")
//                        + " " + resultSet.getString("last_name")
//                        + " " + resultSet.getString("tel_number"));
//                System.out.print("\n=========================\n");
//            }
//
//            ResultSet resultSet1 = statement.executeQuery(commands.rightJoinAndShowCustomerToCars());
//            while (resultSet1.next()) {
//                System.out.print(resultSet1.getInt("id")
//                        + " " + resultSet1.getString("car")
//                        + " " + resultSet1.getString("vin")
//                        + " " + resultSet1.getString("number")
//                        + " " + resultSet1.getInt("year")
//                        + " " + resultSet1.getString("customer_id")
//                        + " " + resultSet1.getInt("id")
//                        + " " + resultSet1.getString("first_name")
//                        + " " + resultSet1.getString("last_name")
//                        + " " + resultSet1.getString("tel_number"));
//                System.out.print("\n=========================\n");
//            }

//            statement.executeUpdate(commands.insertCustomer("John", "Travolta", "+375259997799"));

        } catch (SQLException e) {
            logger.error("Statement didn't create", e);
        }
    }
}
