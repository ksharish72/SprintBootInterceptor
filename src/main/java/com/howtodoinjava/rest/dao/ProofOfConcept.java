package com.howtodoinjava.rest.dao;

import java.io.IOException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.rest.model.Employees;


@Repository
public class ProofOfConcept {
	 @Autowired
	    private EmployeeDAO employeeDao;
	    
	 
	    public Employees getSampleDataFromServer() throws IOException, JSONException 
	    {
	        return employeeDao.getAllEmployees();
	    }
	 
}
