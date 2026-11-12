package com.sj;

public class Person {
	String name;
	Account account;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void withdrawFromAccount( int amt) {
		account.withdraw(13000);
	}
	

}
