package com.poc.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Employees 
{
    private List<Employee> employeeList;
    public String keyDetails;
    public List<Employee> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
 
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
