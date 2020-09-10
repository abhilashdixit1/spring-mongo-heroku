package com.example.springMongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springMongo.model.Book;
import com.example.springMongo.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {
	
	
	@Autowired
	BookRepository bookRepo;
	
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		return bookRepo.findAll();

	}
	
	@PostMapping("/books")
	public  ResponseEntity<Book>  postBook(@RequestBody Book book){
		try {
			Book book1 = bookRepo.save(book);
			return new ResponseEntity<Book>(book1, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
