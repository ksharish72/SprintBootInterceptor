package com.poc.rest.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  
public class ServiceInterceptorAppConfig extends WebMvcConfigurerAdapter  {  

	   @Bean
	   ServiceInterceptor serviceInterceptor() {
	         return new ServiceInterceptor();
	    }
	   
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(serviceInterceptor()).addPathPatterns("/service/rest/services1/");
    }
}
