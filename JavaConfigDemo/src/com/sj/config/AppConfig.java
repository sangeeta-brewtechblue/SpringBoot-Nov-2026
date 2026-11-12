package com.sj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sj.model.Calc1;
import com.sj.model.Calc2;
import com.sj.model.CalcService;
import com.sj.model.User;

@Configuration
public class AppConfig {
	
	@Bean(name="c1")
	public CalcService calcService1() {
		
		  return new Calc1();
		
	}
	
	@Bean(name="c2")
	public CalcService calcService2() {
		
		  return new Calc2();
		
	}
	
	@Bean(name="u1")
	public User user() {
		
		return new User();
	}
	

}
