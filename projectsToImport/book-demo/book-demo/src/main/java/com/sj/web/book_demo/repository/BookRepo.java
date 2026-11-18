package com.sj.web.book_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sj.web.book_demo.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{
	
	
	
	

}
