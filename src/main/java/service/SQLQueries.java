package service;

public class SQLQueries {

    public final static String GetEmployeByID="select * from employees where employeeNumber=? ";
    public final static String GetEmployeBySalary= "select * from employees where salary = ?";

}
