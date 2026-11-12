package com.sj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sj.ActUser;
import com.sj.Person;


public class TestAccountAnnot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        ApplicationContext context = new ClassPathXmlApplicationContext("annotation-config.xml");
        
        ActUser p = (ActUser) context.getBean("u1");
        p.withdrawFromAccount(13000);
	
	
	
	
	
	
	
	
	
	}

}
