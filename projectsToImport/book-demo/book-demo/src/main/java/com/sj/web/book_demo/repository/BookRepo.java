package com.sj.web.book_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sj.web.book_demo.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{
	
	   List<Book> findByAuthor(String author);
	
	   List<Book> findByPriceLessThanEqual(double maxPrice);
	   
	  // @Query("select b from book where b.author =:author AND b.price <= :maxPrice")
	 //  List<Book> findBooksForAuthorUnderPrice( @Param("author") String author, @Param("maxPrice") Double  maxPrice ); 
	   

}
