package com.dpk.application.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpk.application.model.Book;
import com.dpk.application.service.BookService;

@RestController
@RequestMapping("/rest")
public class ReferenceDataController {

	Logger logger = LogManager.getLogger(ReferenceDataController.class);

	@Autowired
	BookService bookService;
	
	@PostMapping("/book/add")
	public Book addBook(@RequestBody Book book) {
		logger.debug("In addBook..." + book);
		return bookService.add(book);
	}
	
	@PutMapping("/book/update")
	public Book updateBook(@RequestBody Book book) {
		logger.debug("In updateBook...");
		return bookService.update(book);
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable Integer id) {
		logger.debug("In getBook..." + id);
		
		return bookService.get(id);
	}
	
	@GetMapping("/book/all")
	public List<Book> getAllBooks() {
		logger.debug("In getAllBooks...");
		return bookService.getAll();
	}
	
	@DeleteMapping("/book/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		logger.debug("In deleteBook..." + id);
		return bookService.delete(id);
	}
	

	
}	
