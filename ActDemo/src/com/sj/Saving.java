package com.sj;

public class Saving implements Account {

	@Override
	public void withdraw(int amt) {
		// TODO Auto-generated method stub
		System.out.println("withdrawing from "
        		+ "Saving account, the amt:"+amt);

	}

}
