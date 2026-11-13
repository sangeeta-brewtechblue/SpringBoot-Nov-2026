package com.sj.web.book_demo.model;

import java.util.Objects;

public class Book {
	
	private int book_id;
	private String title;
	private String author;
	private double price;	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(int book_id, String title, String author, double price) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, book_id, price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && book_id == other.book_id
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
}
