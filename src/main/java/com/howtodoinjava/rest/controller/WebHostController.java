package com.howtodoinjava.rest.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.rest.dao.ProofOfConcept;
import com.howtodoinjava.rest.model.Employees;

@RestController
@RequestMapping(path = "/pocapplication")
public class WebHostController {
	  @Autowired
	    private ProofOfConcept pocObject;
	    
	    @GetMapping(path="/", produces = "application/json")
	    public Employees getSampleDataFromServer() throws IOException, JSONException 
	    {
	        return pocObject.getSampleDataFromServer();
	    }
}
