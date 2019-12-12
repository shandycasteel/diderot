package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.Book;
import com.shandycasteel.diderot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public Set<Book> getAll() {
    Set<Book> bookSet = new HashSet<>();
    bookRepository.findAll().iterator().forEachRemaining(bookSet::add);

    return bookSet;
  }

  @Override
  public Book findById(Long bookId) {
    Optional<Book> bookOptional = bookRepository.findById(bookId);

    if (!bookOptional.isPresent()) {
      throw new RuntimeException("Book Not Found!");
    }

    return bookOptional.get();
  }

  @Override
  public void update(Long bookId, Book bookDetails){
    Book currentBook = findById(bookId);
    currentBook.setTitle(bookDetails.getTitle());
    currentBook.setAuthor(bookDetails.getAuthor());
    currentBook.setCategories(bookDetails.getCategories());
    currentBook.setDescription(bookDetails.getDescription());
    currentBook.setDateField(bookDetails.getDateField());

    bookRepository.save(currentBook);
  }

  @Override
  public void delete(Long bookId){
    bookRepository.deleteById(bookId);
  }

  @Override
  public Long create(Book bookDetails){
    bookRepository.save(bookDetails);

    return bookDetails.getId();
  }

}