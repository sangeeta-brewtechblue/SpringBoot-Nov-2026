package com.sj.web.book_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.web.book_demo.model.Book;

@RestController
@RequestMapping("/api")
public class BookController {
	   
	   List<Book> books ;
	   
	   
	
	
	   public BookController() {
		super();
		books = new ArrayList<Book>();
		Book book1 = new Book(1,"not without mu doaughter","Betty Mehmoody",450);
		Book book2 = new Book(2,"Bitter chocolate","Pinky Virani",350);
		Book book3 = new Book(3,"Accidental PrimeMinister","Sanjay Baru",950);
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
	}

	@GetMapping("/greetings")
	   public String sayHello() {
		   
		   return ("Hello world");
	   }
	  
	   @GetMapping("/books")
	   public List<Book> getAllBooks(){
		   
		     return books; 
		   
		   
	   }
	
	 
	

}
