package com.poc.rest.memcache;

import org.cache2k.Cache;

import org.cache2k.Cache2kBuilder;


public class MemoryCache {
	 Cache<String, String> cache = new Cache2kBuilder<String, String>() {}
     .name("responseHolder")
     .eternal(true)
     .entryCapacity(100)
     .build();
 	public void Add(String key,String actualServiceresponse) {
		// TODO Auto-generated method stub
 	cache.peekAndPut(key, actualServiceresponse);
 	}
 	public String Get(String key) {
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
