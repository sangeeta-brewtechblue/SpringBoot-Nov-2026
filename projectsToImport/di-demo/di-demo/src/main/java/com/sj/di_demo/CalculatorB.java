/**
 * 
 */
package com.sj.di_demo;

import org.springframework.stereotype.Component;

/**
 * @author sange
 *
 */
@Component("B")
public class CalculatorB implements Calculator{
	
	public CalculatorB() {
		super();
		//System.out.println("constr calc B");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void findSqrroot(int n) {
		// TODO Auto-generated method stub
		System.out.println("sqr root found by B is :"+ Math.sqrt(n));
	}

}
