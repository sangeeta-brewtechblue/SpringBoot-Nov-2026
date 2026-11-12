package com.sj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sj.config.AppConfig;
import com.sj.model.CalcService;
import com.sj.model.User;

public class TestJavaConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	      ApplicationContext context = 
	    		  new AnnotationConfigApplicationContext(AppConfig.class);
	        // CalcService obj =  (CalcService) context.getBean("c1");
	      //   obj.calculate(4, 9, "add");
	        User u = (User) context.getBean("u1");
	        u.invokeCalc(4, 9, "add");
	
	}

}
