package com.poc.rest.dao;

import org.springframework.stereotype.Repository;

import com.poc.rest.model.Employee;
import com.poc.rest.model.Employees;

@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }
    
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }

	public Employees getAllEmployees(String key) {
		// TODO Auto-generated method stub

    	list.keyDetails="The service is called from the key " + key;
    	System.out.println("harish :" + list.toString());
        return list;
        }
}
