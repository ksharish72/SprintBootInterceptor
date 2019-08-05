package com.poc.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poc.rest.dao.EmployeeDAO;
import com.poc.rest.memcache.MemoryCache;
import com.poc.rest.model.Employee;
import com.poc.rest.model.Employees;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController 
{
    @Autowired
    public EmployeeDAO employeeDao;
	public static MemoryCache memoryCache=new MemoryCache();
	@GetMapping(path="/sampleService1", produces = "application/json")
    public Employees InterceptCacheAndGetEmployees(@RequestParam("key")String key) 
    {
        System.out.println("Intercept Cache function invoke");
        return employeeDao.getAllEmployees(key);
    }
    
    @GetMapping(path="/sampleService2", produces = "application/json")
    public Employees UpdateCacheAndgetEmployees(@RequestParam("key")String key,@RequestParam("refresh")int refresh) 
    {
    	if(refresh==1) {
    		memoryCache.Add(key, employeeDao.getAllEmployees(key));
    		return memoryCache.Get(key);
    	}
    	else {
    		return memoryCache.Get(key);
    	}
    }
    
    
    @GetMapping(path="/sampleService3", produces = "application/json")
    public Employees getEmployees(@RequestParam("key")String key) 
    {
        return employeeDao.getAllEmployees(key);
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody Employee employee) 
                 throws Exception 
    {       
        //Generate resource id
        Integer id = employeeDao.getAllEmployees(headerLocation).getEmployeeList().size() + 1;
        employee.setId(id);
        
        //add resource
        employeeDao.addEmployee(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
