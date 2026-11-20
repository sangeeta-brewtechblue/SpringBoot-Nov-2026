package com.sj.web.book_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.sj.web.book_demo.model.Book;
import com.sj.web.book_demo.repository.BookRepo;

@DataJpaTest
public class BookRepoTest {
	
	   @Autowired 
	   private BookRepo bookRepository;
	    
	    
	    @Test
	   public  void saveAndFindById_savesAllFields() {
	    	
	    	Book saved = bookRepository.save(new Book(1,"Spring In Action","Manning",500));
	    	
	    	assertNotNull(saved.getBook_id());
	    	
	    	
	    	   Optional<Book>  found=        bookRepository.findById(saved.getBook_id());
	    	   
	    	  assertTrue(found.isPresent());
	    	  assertEquals("Spring In Action",found.get().getTitle());
	    	  assertEquals("Manning",found.get().getAuthor());
	    	  assertEquals(500,found.get().getPrice());
	    	    	
	    }
	
	
	

}
