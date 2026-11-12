package com.sj.model;

public class Calc2 implements CalcService {

	@Override
	public void calculate(int x, int y, String operation) {
		// TODO Auto-generated method stub
          System.out.println("THe result of operation calc2"+operation+(x+y));
	}

}
