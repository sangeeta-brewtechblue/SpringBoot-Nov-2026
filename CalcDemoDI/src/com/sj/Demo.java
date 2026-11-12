package com.sj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        
        User u1 = (User) context.getBean("u2");
        u1.invokefindSqrt(13);
	    
     //   User u2 = (User) context.getBean("u1");
        
    //    System.out.println(u1==u2);
        
	     
	}

}
