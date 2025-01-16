package com.maria;

import service.EmployeeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EmployeeService employeeService = new EmployeeService();
        employeeService.getAllEmployees();
        employeeService.getEmployeeById();
        employeeService.getEmployeeByIdAndName();
        employeeService.InsertEmployee();
        employeeService.updateEmployee();
        employeeService.useSQLQueries();
    }
}
