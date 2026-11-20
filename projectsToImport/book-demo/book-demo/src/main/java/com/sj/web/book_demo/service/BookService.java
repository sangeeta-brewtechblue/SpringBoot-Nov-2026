package com.sj.web.book_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.web.book_demo.exceptions.BookNotFoundException;
import com.sj.web.book_demo.exceptions.DuplicateIdException;
import com.sj.web.book_demo.model.Book;
import com.sj.web.book_demo.repository.BookRepo;
@Service
public class BookService {
	
	@Autowired
	  BookRepo bookRepository;
	
	
	  public List<Book> getAllBooks(){
		   
		   return bookRepository.findAll();
			   
	   }	  
	   
	   public Book getBookById( int bookId) {
	  
	      return  bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException(bookId));
	      
	       
	      // return new Book(0,null,null,0.0);
	       
	   }
	   
	   public Book createBook( Book newBook) {
		      
		      if(bookRepository.findById(newBook.getBook_id())!=null)
		    	  throw new DuplicateIdException(newBook.getBook_id());
		   
		      return bookRepository.save(newBook);
		   
	   }
	   
	   public List<Book>  getBooksByAuthor(String author){
		   
		    return  bookRepository.findByAuthor(author);
		   
	   }
	   
	   public List<Book> findBooksUnderPrice(double price){
		   
		 return  bookRepository.findByPriceLessThanEqual(price);
	   }
	   
	  
	  // public List<Book> findBooksByAuthorUnderPrice (String author, double maxPrice){
		   
		   
		 //  return bookRepository.findBooksForAuthorUnderPrice(author, maxPrice);
		   
		   
	 //  }
	   
	   
	  
	   
	   
	   
	   public Book updateBook( Book toUpdate, int id ) {
		     
		   Book toBeUpdated =   getBookById( id);
		   
		   toBeUpdated.setAuthor(toUpdate.getAuthor());
	       toBeUpdated.setPrice(toUpdate.getPrice());
	       toBeUpdated.setTitle(toUpdate.getTitle());
	       
	      return bookRepository.save(toBeUpdated);
	  }
	   
	  
	  public List<Book> removeBookById( int id){
		  
		    bookRepository.deleteById(id);
		    
		    return getAllBooks();
	  }
	 
	
	
	

}
