package com.sj.core.simple_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SimpleDemoApplication.class, args);
	
	   User u1 = (User) context.getBean("u1");
	
	      u1.invokefindSqrt(13);  
	}

}
