/**
 * 
 */
package com.sj.di_demo;

import org.springframework.stereotype.Component;

/**
 * @author sange
 *
 */
@Component("A")
public class CalculatorA implements Calculator{
	
	

	public CalculatorA() {
		super();
		//System.out.println("constr calc A");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void findSqrroot(int n) {
		// TODO Auto-generated method stub
		System.out.println("sqr root found by A is :"+ Math.sqrt(n));
	}

}
