package com.poc.rest;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.rest.memcache.AWSElasticCache; 

@SpringBootApplication 
public class SpringBootDemoApplication {

    public static void main(String[] args) {
    	AWSElasticCache.Initialize();
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
