package com.dpk.application.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dpk.application.model.Book;
import com.dpk.application.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	Logger logger = LogManager.getLogger(BookService.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	public Book add(Book  book) {
		logger.debug("In add.." + book);
		long seq = sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME);
		
		book.setId(seq);
		bookRepository.save(book);
		
		return book;
	}

	public Book get(Integer id) {
		Optional<Book> opt = bookRepository.findById(id);
		return opt.isPresent()?opt.get():null;
	}
	
	public Book update(Book book) {
		logger.debug("In update.." + book);
		return bookRepository.save(book);
	}
	
	public String delete(Integer id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return "Book deleted with id:" + id;
		} else {
			return "No book found with id:" + id + " to delete";
		}
		
	}
	
	public List<Book> getAll() {
		List<Book> books = bookRepository.findAll();		
		return books;
	}
	
}
