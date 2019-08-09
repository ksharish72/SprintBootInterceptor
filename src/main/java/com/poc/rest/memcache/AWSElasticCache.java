package com.poc.rest.memcache;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;


import net.spy.memcached.MemcachedClient;

public class AWSElasticCache {
	
	public static MemcachedClient client;
     	public static void Add(String key,String actualServiceresponse) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
          client.set(key, 36000000, "hello");
 	}
 	public static String Get(String key) {
		// TODO Auto-generated method stub
 		Object myObject = client.get(key);
 		System.out.println("Value from cache: "+ myObject.toString());
 		if(myObject == null) { // the object does not exist
 		    // add the value
 			return null;
 		} else {
return (String) myObject;
		}
 	}
 	
 	public static boolean CheckIfExistsInCache(String key) {
		// TODO Auto-generated method stub
 		Object myObject = client.get(key);
 		if(myObject == null) { // the object does not exist
 		    // add the value
 			return false;
 		} else {
 			return true;
		}
 	}
 	
	public static void Initialize()  {
		// TODO Auto-generated method stub
		  String configEndpoint = "employeedetails.iz5dqn.cfg.use1.cache.amazonaws.com";
	      Integer clusterPort = 11211;
	      try {
			client = new MemcachedClient(
			                           new InetSocketAddress(configEndpoint, 
			                                                 clusterPort));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        	
	}     
}
