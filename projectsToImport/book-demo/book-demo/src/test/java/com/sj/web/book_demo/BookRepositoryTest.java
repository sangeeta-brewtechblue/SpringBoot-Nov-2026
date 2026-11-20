package com.sj.web.book_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import  com.sj.web.book_demo.model.Book;
import com.sj.web.book_demo.repository.BookRepo;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;


@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepo bookRepository;

    @Test
    void saveAndFindById_persistsAllBookFields() {
        Book saved = bookRepository.save(new Book(1,"Clean Code", "Robert C. Martin", 550.0));

        assertNotNull(saved.getBook_id());

        Optional<Book> found = bookRepository.findById(saved.getBook_id());
        assertTrue(found.isPresent());
        assertEquals("Clean Code", found.get().getTitle());
        assertEquals("Robert C. Martin", found.get().getAuthor());
        assertEquals(550.0, found.get().getPrice());
    }

    @Test
    void findByAuthor_returnsMatchingBooks() {
        bookRepository.save(new Book(1,"Clean Code", "Robert C. Martin", 550.0));
        bookRepository.save(new Book(2,"Clean Architecture", "Robert C. Martin", 600.0));
        bookRepository.save(new Book(3,"Effective Java", "Joshua Bloch", 650.0));

        List<Book> martinBooks = bookRepository.findByAuthor("Robert C. Martin");

        assertEquals(2, martinBooks.size());
    }

    @Test
    void updateAndDelete_modifiesAndRemovesBook() {
        Book saved = bookRepository.save(new Book(1,"Old Title", "Author", 300.0));

        saved.setTitle("New Title");
        saved.setPrice(350.0);
        Book updated = bookRepository.save(saved);
        assertEquals("New Title", updated.getTitle());
        assertEquals(350.0, updated.getPrice());

        bookRepository.deleteById(saved.getBook_id());
        assertFalse(bookRepository.findById(saved.getBook_id()).isPresent());
    }
}