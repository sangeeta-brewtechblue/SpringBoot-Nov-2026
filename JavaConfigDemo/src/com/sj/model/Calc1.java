package com.sj.model;

public class Calc1 implements CalcService {

	@Override
	public void calculate(int x, int y, String operation) {
		// TODO Auto-generated method stub
          System.out.println("THe result of operation calc1"+operation+(x+y));
	}

}
