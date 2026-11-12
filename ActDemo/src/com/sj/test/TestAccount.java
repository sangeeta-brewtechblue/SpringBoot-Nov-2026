package com.sj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sj.Person;


public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        
        Person p = (Person) context.getBean("p1");
        p.withdrawFromAccount(13000);
	
	
	
	
	
	
	
	
	
	}

}
