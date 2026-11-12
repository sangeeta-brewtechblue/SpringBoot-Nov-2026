package com.sj.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class User {
	
	@Autowired
	@Qualifier("c1")
    CalcService c;  
    
	
	public User() {
		//super();
		System.out.println("constr User");
		// TODO Auto-generated constructor stub
	}	

	



	public void invokeCalc(int x,int y,String op) {
		
		c.calculate(x,y,op);
		 
	}





	public CalcService getC() {
		return c;
	}





	public void setC(CalcService c) {
		this.c = c;
	}

	
	
	

}


/*
public static void main(String[] args) {
	// TODO Auto-generated method stub

	   Calculator c  = new CalculatorB();
	   c.findSqrroot(13);
  
     


}*/
