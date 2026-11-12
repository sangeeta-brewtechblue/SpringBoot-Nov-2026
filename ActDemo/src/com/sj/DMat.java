package com.sj;

public class DMat implements Account {

	@Override
	public void withdraw(int amt) {
		// TODO Auto-generated method stub
        System.out.println("withdrawing from "
        		+ "Dmat account, the amt:"+amt);
	}

}
