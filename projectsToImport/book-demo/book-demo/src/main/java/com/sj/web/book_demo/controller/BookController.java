package com.sj.web.book_demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.web.book_demo.model.Book;
//this is a stereo typed annotation
@RestController
@RequestMapping("/api")
public class BookController {
	   
	   List<Book> books ;
	   
	
	   public BookController() {
		super();
		books = new ArrayList<Book>();
		Book book1 = new Book(1,"not without my doaughter","Betty Mehmoody",450);
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
	   
	   @GetMapping("/books/{bookId}")
	   public Book getBookById( @PathVariable   int bookId) {
		   
		     Optional<Book> found =  books.stream().filter((book)->book.getBook_id()==bookId).findFirst();
		     
		     if(found.isPresent()) {
		    	 return found.get();
		     }
		    
		     else
		    	 return (new Book(0,"null","null",0.00));
		   
	   }
	   
	   @PostMapping("/books")
	   public Book createNewBook(@RequestBody Book newBook) {
		   
		    boolean flag=   books.add(newBook);
		    
		    if (flag == true)
		    	return getBookById(newBook.getBook_id());
		    
		    else
		    	 return (new Book(0,"null","null",0.00));
		   
	   }
	   
	   @PutMapping("/books/{id}")
	   public Book updateBook(@RequestBody Book toUpdate,@PathVariable int id ) {
		   
		   Book   bookToBeUpdated = getBookById(id) ;
		     
		   bookToBeUpdated.setAuthor(toUpdate.getAuthor());
		   bookToBeUpdated.setTitle(toUpdate.getTitle());
		   bookToBeUpdated.setPrice(toUpdate.getPrice());
		   
		   return getBookById(id);
		  
	   }
	   
	   @DeleteMapping("/books/{id}")
	   public List<Book> deleteBookById( @PathVariable int id){
		   
		     Book toRemove =  getBookById(id);
		     
		     books.remove(toRemove);
		     
		     return books;
		     
		   
	   }
	   
	   
	   
	

}
