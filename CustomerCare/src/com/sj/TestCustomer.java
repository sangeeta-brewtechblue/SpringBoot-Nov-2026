package com.sj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("annotation-config.xml");
        
		Customer c1 =   (Customer) context.getBean("cu1");
		
		 c1.registerMajorOrMinor();
		 System.out.println(c1.name);
		
		
	}

}
