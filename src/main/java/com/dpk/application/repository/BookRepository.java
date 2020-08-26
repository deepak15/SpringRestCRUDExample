package com.dpk.application.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dpk.application.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

}
