package com.poc.rest.controller;

import java.net.URI;
import java.util.concurrent.ExecutionException;

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
import com.poc.rest.memcache.AWSElasticCache;
import com.poc.rest.memcache.MemoryCache;


@RestController
@RequestMapping(path = "/service")
public class ServiceController 
{
	@GetMapping(path="/rest/services1", produces = "application/json")
    public String InterceptCacheAndGetEmployees(@RequestParam("key")String key) 
    {
        System.out.println("Intercept Cache function invoke");
        return CallActualService(key);
    }
    
    private String CallActualService(String key) {
		// TODO Auto-generated method stub
		return "The service is called from the key " + key;
	}

	@GetMapping(path="/rest/services2", produces = "application/json")
    public Object UpdateCacheAndgetEmployees(@RequestParam("key")String key,@RequestParam("refresh")int refresh) throws InterruptedException, ExecutionException 
    {
    	if(refresh==1) {
    		AWSElasticCache.Add(key, CallActualService(key));
    		return AWSElasticCache.Get(key);
    	}
    	else {
    		return AWSElasticCache.Get(key);
    	}
    }
    
    
    @GetMapping(path="/rest/services3", produces = "application/json")
    public String getFromActualService(@RequestParam("key")String key) 
    {
        return CallActualService(key);
    }

}
