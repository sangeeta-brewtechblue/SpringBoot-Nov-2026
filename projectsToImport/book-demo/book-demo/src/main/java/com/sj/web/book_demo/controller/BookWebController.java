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
import com.sj.web.book_demo.service.BookService;


@RestController
@RequestMapping("/web")
public class BookWebController {
	
	  @Autowired
	  BookService bookService;
		
	  @GetMapping("/greetings")
	   public String sayHello() {
		   
		   return ("Hello world");
	   }
	 
	  @GetMapping("/books")
	   public List<Book> getAllBooks(){
		   
		   return bookService.getAllBooks();
			   
	   }	  
	   @GetMapping("/books/{bookId}")
	   public Book getBookById( @PathVariable   int bookId) {
	  
		   
		  return bookService.getBookById(bookId);
	     
	       
	   }
	   
	   @PostMapping("/books")
	   public Book createBook(@RequestBody Book newBook) {
		   
		      return bookService.createBook(newBook);
		   
	   }
	   
	   
	   @PutMapping("/books/{id}")
	   public Book updateBook(@RequestBody Book toUpdate,@PathVariable int id ) {
		     
		   return bookService.updateBook(toUpdate,id);
		   
		   /*
			 * Book toBeUpdated = getBookById( id);
			 * 
			 * toBeUpdated.setAuthor(toUpdate.getAuthor());
			 * toBeUpdated.setPrice(toUpdate.getPrice());
			 * toBeUpdated.setTitle(toUpdate.getTitle());
			 */
	       
	     
	  }
	   
	  @DeleteMapping("/books/{id}")
	  public List<Book> removeBookById(@PathVariable int id){
		  
		    bookService.removeBookById(id);
		    
		    return getAllBooks();
	  }
	  
	  @GetMapping("/books/authors/{author}")
	  public List<Book> getBooksByAuthor(@PathVariable String author){
		  
		    return bookService.getBooksByAuthor(author);
		  
		   
		  
	  }
	 
	  @GetMapping("/books/prices/{maxPrice}")
	  public List<Book> getBooksUnderPrice( @PathVariable double maxPrice){
		  
		  return bookService.findBooksUnderPrice(maxPrice);
		  
	  }
	   
	 
	   

}
