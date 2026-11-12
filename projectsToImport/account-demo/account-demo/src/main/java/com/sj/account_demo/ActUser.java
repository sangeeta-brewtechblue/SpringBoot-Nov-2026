package com.sj.account_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class ActUser {
	@Value("user1")
	String name;
	@Autowired
	@Qualifier("s")
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
