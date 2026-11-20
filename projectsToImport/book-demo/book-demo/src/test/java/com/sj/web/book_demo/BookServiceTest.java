package com.sj.web.book_demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sj.web.book_demo.repository.BookRepo;
import com.sj.web.book_demo.service.BookService;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sj.web.book_demo.exceptions.BookNotFoundException;
import com.sj.web.book_demo.exceptions.DuplicateIdException;
import  com.sj.web.book_demo.model.Book;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void getBookById_returnsBook_whenExists() {
        Book book = new Book(1, "Spring in Action", "Craig Walls", 499.0);
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        Book result = bookService.getBookById(1);

        assertEquals("Spring in Action", result.getTitle());
        assertEquals("Craig Walls", result.getAuthor());
        assertEquals(499.0, result.getPrice());
    }

    @Test
    void getBookById_throwsBookDoesNotExist_whenMissing() {
        when(bookRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(99));
    }
    
   @Test void createBook_throwsDuplicateId_whenIdAlreadyExists() { 
		 Book book = new Book(1, "Spring in Action", "Craig Walls", 499.0);
	 
		 when(bookRepository.existsById(1)).thenReturn(true);
	  
	     assertThrows(DuplicateIdException.class, () -> bookService.createBook(book));
	  }
	  
   @Test void deleteBook_deletes_whenExists() {
	  when(bookRepository.existsById(1)).thenReturn(true);
	  
	  bookService.removeBookById(1);
	  
	  verify(bookRepository).deleteById(1); }
	 
}