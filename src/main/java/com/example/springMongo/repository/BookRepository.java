package com.example.springMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springMongo.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
