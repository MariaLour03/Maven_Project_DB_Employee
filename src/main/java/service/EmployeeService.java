package service;

import utility.DBConnection;
import java.sql.*;

public class EmployeeService {

    public void getAllEmployees() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDBConnection();  // call the DBConnection class name by itself since it is static
        System.out.println("\n------------MySQL JDBC Connection Established----------\n");

        String selectSQL = "select * from employees";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(selectSQL);

        while (resultSet.next()) {  // Iterates thru the resultSet
            String employeeID = resultSet.getString("employeeNumber");
            String fName = resultSet.getString("firstName");
            String lName = resultSet.getString("lastName");
            System.out.println(employeeID + " | " + fName + " | " + lName);

            connection.close();
        }
    }

    public void getEmployeeById() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDBConnection();

        String selectSQL = "select * from employees where employeeNumber=?";
        PreparedStatement ps = connection.prepareStatement(selectSQL);
        ps.setInt(1, 1088);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println(name + " | " + email);

            connection.close();
        }
    }

    public void getEmployeeByIdAndName() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDBConnection();

        String selectSQL = "select * from employees where employeeNumber=? and lastName=?";
        PreparedStatement ps = connection.prepareStatement(selectSQL);

        ps.setInt(1, 1165); // for first ? so it's index 1
        ps.setString(2, "Jennings"); // for second ? so it's index 2
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println(name + " | " + email);

            connection.close();
        }
    }

    public void InsertEmployee() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDBConnection();

        String selectSQL = "INSERT INTO EMPLOYEES(officeCode, firstName, lastName, email, extension, reportsTo," +
                " vacationHours, employeeNumber, jobTitle) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(selectSQL);
        
        ps.setInt(1, 6);
        ps.setString(2, "Jane");
        ps.setString(3, "Doe");
        ps.setString(4, "janedoe@gmail.com");
        ps.setString(5, "x7071");
        ps.setInt(6, 1002);
        ps.setInt(7, 35);
        ps.setInt(8, 1051);
        ps.setString(9, "Administrator");
        int affectRows = ps.executeUpdate();

        System.out.println(affectRows + " rows was affected");

        connection.close();
    }

    public void updateEmployee() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDBConnection();

        String selectQuery = "update employees set firstName=?, lastName=? where employeeNumber=?";

        PreparedStatement ps = connection.prepareStatement(selectQuery);

        ps.setString(1, "Tracy");
        ps.setString(2, "Thomas");
        ps.setLong(3, 1002);
        int affectRows = ps.executeUpdate();
        System.out.println(affectRows + " rows was affected");

        connection.close();
    }

    public void useSQLQueries() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDBConnection();
        PreparedStatement ps = connection.prepareStatement(SQLQueries.GetEmployeByID);

        ps.setInt(1, 1076);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println(name + " | " + email);
        }
        connection.close();
    }

}

