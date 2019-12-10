package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.Book;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BookService extends CrudService<Book, Long> {

  //Finds all books
  Set<Book> getAll();

  // Find a Book by ID
  Book findById(Long bookId);

  // Create and insert a new Book
  Long create(Book bookDetails);

  // Update a Book
  void update(Long bookId, Book bookDetails);

  // Delete a Book
  void delete(Long bookId);

}
