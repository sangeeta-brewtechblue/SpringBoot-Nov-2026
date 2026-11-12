package com.sj.di_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		
		 ApplicationContext context = SpringApplication.run(DiDemoApplication.class, args);
		 
		 User u1 = (User) context.getBean("u1");
		 
		 u1.invokefindSqrt(14);
	
	}
	/*
	 * @Bean("A") public Calculator calculatorA() {
	 * 
	 * return new CalculatorA(); }
	 * 
	 * @Bean("B") public Calculator calculatorB() {
	 * 
	 * return new CalculatorB(); }
	 */

}
