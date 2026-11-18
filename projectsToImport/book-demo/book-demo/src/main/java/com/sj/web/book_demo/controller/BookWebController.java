package com.sj.web.book_demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.web.book_demo.model.Book;
import com.sj.web.book_demo.repository.BookRepo;


@RestController
@RequestMapping("/web")
public class BookWebController {
	
	  @Autowired
	  BookRepo bookRepository;
		
	  @GetMapping("/greetings")
	   public String sayHello() {
		   
		   return ("Hello world");
	   }
	 
	  @GetMapping("/books")
	   public List<Book> getAllBooks(){
		   
		   return bookRepository.findAll();
			   
	   }	  
	   @GetMapping("/books/{bookId}")
	   public Book getBookById( @PathVariable   int bookId) {
	  
	      Optional<Book> book  =  bookRepository.findById(bookId);
	      
	       if(book.isPresent())
	    	return book.get();
	      
	       return new Book(0,null,null,0.0);
	       
	   }
	   
	   @PostMapping("/books")
	   public Book createBook(@RequestBody Book newBook) {
		   
		      return bookRepository.save(newBook);
		   
	   }
	   
	   
	   @PutMapping("/books/{id}")
	   public Book updateBook(@RequestBody Book toUpdate,@PathVariable int id ) {
		     
		   Book toBeUpdated =   getBookById( id);
		   
		   toBeUpdated.setAuthor(toUpdate.getAuthor());
	       toBeUpdated.setPrice(toUpdate.getPrice());
	       toBeUpdated.setTitle(toUpdate.getTitle());
	       
	      return bookRepository.save(toBeUpdated);
	  }
	   
	  @DeleteMapping("/books/{id}")
	  public List<Book> removeBookById(@PathVariable int id){
		  
		    bookRepository.deleteById(id);
		    
		    return getAllBooks();
	  }
	    
	   
	   
	   
	   

}
