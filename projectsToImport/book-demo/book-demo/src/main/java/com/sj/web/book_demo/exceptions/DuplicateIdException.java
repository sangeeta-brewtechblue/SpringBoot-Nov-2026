package com.sj.web.book_demo.exceptions;

public class DuplicateIdException extends RuntimeException {

	public DuplicateIdException(int id) {
		super("Id already exists"+id);
		// TODO Auto-generated constructor stub
	}
	
	   

}
