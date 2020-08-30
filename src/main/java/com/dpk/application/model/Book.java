package com.dpk.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
public class Book {
	
	@Transient
	public static final String SEQUENCE_NAME = "book_sequence";
	
	
	@Id
	private long id;
	
	private String name;
	
	private String author;
	
	private double price;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	public static Book getDummy() {
		Book book = new Book();
		book.id = 999;
		book.name="Math";
		book.author="Das";
		book.price= Math.random();
		return book;
	}
}
