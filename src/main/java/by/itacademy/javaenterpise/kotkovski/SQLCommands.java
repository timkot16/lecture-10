package by.itacademy.javaenterpise.kotkovski;

public class SQLCommands {

    public String showCustomerTable() {
        return "SELECT * FROM Customer";
    }

    public String insertCustomer(String first_name, String last_name, String tel_number){
        return "INSERT INTO Customer (first_name, last_name, tel_number) " +
                "VALUES ('" + first_name + "','" + last_name + "','" + tel_number + "')";
    }

    public String updateCustomerTelNumber(String first_name, String tel_number) {
        return "UPDATE Customer SET tel_number='" + tel_number + "' WHERE NAME='" + first_name + "'";
    }

    public String deleteCustomerByTelNumber(String tel_number) {
        return "DELETE FROM Customer WHERE tel_number='" + tel_number + "'";
    }

    public String joinAndShowCustomerToCars() {
        return "SELECT Cars.car, Cars.vin, Customer.first_name " +
                "FROM Cars " +
                "JOIN Customer ON Cars.customer_id = Customer.id";
    }

    public String rightJoinAndShowCustomerToCars() {
        return "SELECT * FROM Cars " +
                "RIGHT JOIN Customer ON Cars.customer_id = Customer.id";
    }

}
