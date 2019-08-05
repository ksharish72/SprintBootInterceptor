package com.poc.rest.memcache;

import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;

import com.poc.rest.model.Employees;

public class MemoryCache {
	 Cache<String, Employees> cache = new Cache2kBuilder<String, Employees>() {}
     .name("responseHolder")
     .eternal(true)
     .entryCapacity(100)
     .build();
 	public void Add(String key,Employees actualServiceresponse) {
		// TODO Auto-generated method stub
 	cache.peekAndPut(key, actualServiceresponse);
 	}
 	public Employees Get(String key) {
		// TODO Auto-generated method stub
 		if(cache.containsKey(key)) {
 		 	return cache.peek(key); 			
 		}
 		return null;
 	}
 	
 	public boolean CheckIfExistsInCache(String key) {
		// TODO Auto-generated method stub
 		if(cache.containsKey(key)) {
 		 	return true;			
 		}else {
 			return false;
 		}
 	}
 	
     
}
