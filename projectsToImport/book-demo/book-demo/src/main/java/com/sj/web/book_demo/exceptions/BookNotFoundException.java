package com.sj.web.book_demo.exceptions;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(int bookId) {
		super("No book avaialble with this id"+bookId);
		// TODO Auto-generated constructor stub
	}
	

}
