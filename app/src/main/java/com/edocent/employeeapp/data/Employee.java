package com.edocent.employeeapp.data;

/**
 * Created by ankursrivastava on 3/1/16.
 */
public class Employee {

    private String employeeName;
    private String employeeNumber;
    private String employeeTitle;

    public Employee(String employeeName, String employeeNumber, String employeeTitle) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.employeeTitle = employeeTitle;
    }

    public static final Employee[] employees = {
            new Employee("Ankur", "7340", "Developer"),
            new Employee("John", "7341", "Designer"),
            new Employee("Mark", "7342", "Sales")
    };

    public static String[] getEmployeeNames(){
        String [] employeeNames = new String[Employee.employees.length];
        for(int i=0; i<Employee.employees.length; i++){
            employeeNames[i] = employees[i].getEmployeeName();
        }
        return employeeNames;
    }

    @Override
    public String toString(){
        return getEmployeeNumber()+" "+getEmployeeName();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }
}
