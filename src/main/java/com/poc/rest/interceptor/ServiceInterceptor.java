package com.poc.rest.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.poc.rest.controller.EmployeeController;
import com.poc.shared.ObjectUtil;

public class ServiceInterceptor  implements HandlerInterceptor {
	   @Override
	   public boolean preHandle
	      (HttpServletRequest request, HttpServletResponse response, Object handler) 
	      throws Exception {
		   long startTime = System.currentTimeMillis();
	        System.out.println("\n-------- LogInterception.preHandle --- ");
	        System.out.println("Request URL: " + request.getRequestURL());
	        System.out.println("Start Time: " + System.currentTimeMillis());
	        request.setAttribute("startTime", startTime);
	        String parameterKey= request.getParameter("key");
	        if(EmployeeController.memoryCache.CheckIfExistsInCache(parameterKey)) {
	        	  response.setContentType("application/json");
	        	  String jsonString=ObjectUtil.serializeObjectToString(  EmployeeController.memoryCache.Get(parameterKey));
	        	  response.getWriter().write(jsonString
	    	        	);
	        	return false;
	        }else {
		        return true;
	        }
	  }
	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, ModelAndView modelAndView) throws Exception {
	        System.out.println("\n-------- LogInterception.postHandle --- ");
	        System.out.println("Request URL: " + request.getRequestURL());
	 
	        // You can add attributes in the modelAndView
	        // and use that in the view page
	   }
	   @Override
	   public void afterCompletion
	      (HttpServletRequest request, HttpServletResponse response, Object 
	      handler, Exception exception) throws Exception {
	      
	      System.out.println("\n-------- LogInterception.afterCompletion --- ");
	      
	        long startTime = (Long) request.getAttribute("startTime");
	        long endTime = System.currentTimeMillis();
	        System.out.println("Request URL: " + request.getRequestURL());
	        System.out.println("End Time: " + endTime);
	 
	        System.out.println("Time Taken: " + (endTime - startTime));
	   }
}