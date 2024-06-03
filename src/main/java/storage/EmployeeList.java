package main.java.storage;

import main.java.models.Employee;

import java.util.HashMap;

public class EmployeeList {
    private static HashMap<String, Employee> employees;

    private static EmployeeList employeeList=null;

    private EmployeeList(){
        employees = new HashMap<>();
    }


    public static EmployeeList getList(){
        if(employeeList == null){
            employeeList = new EmployeeList();
        }
        return employeeList;
    }

    public boolean add(String empId, Employee employee){
        EmployeeList.employees.put(empId, employee);
        return true;
    }

    public HashMap<String, Employee> list(){
        return EmployeeList.employees;
    }
}
