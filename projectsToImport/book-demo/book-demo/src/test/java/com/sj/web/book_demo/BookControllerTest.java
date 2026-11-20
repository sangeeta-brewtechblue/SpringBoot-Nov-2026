package com.sj.web.book_demo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.sj.web.book_demo.controller.BookController;
import com.sj.web.book_demo.exceptions.BookNotFoundException;
import com.sj.web.book_demo.exceptions.DuplicateIdException;
import com.sj.web.book_demo.model.Book;
import com.sj.web.book_demo.service.BookService;

import tools.jackson.databind.json.JsonMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
public class BookControllerTest {
	    @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private JsonMapper objectMapper;

	    @Mock
	    private BookService bookService;

	    @Test
	    void createBook_returns201AndBookJson() throws Exception {
	        Book book = new Book(1, "Effective Java", "Joshua Bloch", 650.0);
	        when(bookService.createBook(any(Book.class))).thenReturn(book);

	        mockMvc.perform(post("/api/books")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(objectMapper.writeValueAsString(book)))
	                .andExpect(status().isCreated())
	                .andExpect(jsonPath("$.id").value(1))
	                .andExpect(jsonPath("$.title").value("Effective Java"))
	                .andExpect(jsonPath("$.price").value(650.0));
	    }

	    @Test
	    void createBook_returns409OnDuplicateId() throws Exception {
	        Book book = new Book(1, "Effective Java", "Joshua Bloch", 650.0);
	        when(bookService.createBook(any(Book.class))).thenThrow(new DuplicateIdException(1));

	        mockMvc.perform(post("/api/books")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(objectMapper.writeValueAsString(book)))
	                .andExpect(status().isConflict())
	                .andExpect(content().string("Id already exists"+1));
	    }

	    
	    @Test
	    void getBook_returns404WhenNotFound() throws Exception {
	        when(bookService.getBookById(99)).thenThrow(new BookNotFoundException(99));

	        mockMvc.perform(get("/api/books/99"))
	                .andExpect(status().isNotFound())
	                .andExpect(content().string("Book does not exist with id: 99"));
	    }

		/*
		 * @Test void updateBook_returns200AndUpdatedBook() throws Exception { Book
		 * updated = new Book(1, "Effective Java 3rd Ed.", "Joshua Bloch", 750.0);
		 * when(bookService.updateBook( any(Book.class)),eq(1)).thenReturn(updated);
		 * 
		 * mockMvc.perform(put("/api/books/1") .contentType(MediaType.APPLICATION_JSON)
		 * .content(objectMapper.writeValueAsString(updated)))
		 * .andExpect(status().isOk())
		 * .andExpect(jsonPath("$.title").value("Effective Java 3rd Ed."))
		 * .andExpect(jsonPath("$.price").value(750.0)); }
		 */

	    @Test
	    void deleteBook_returns204() throws Exception {
	        doNothing().when(bookService).removeBookById(1);

	        mockMvc.perform(delete("/api/books/1"))
	                .andExpect(status().isNoContent());
	    }
      
}
