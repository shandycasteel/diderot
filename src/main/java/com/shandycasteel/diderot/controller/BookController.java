package com.shandycasteel.diderot.controller;

import com.shandycasteel.diderot.model.Book;
import com.shandycasteel.diderot.model.Category;
import com.shandycasteel.diderot.repository.BookRepository;
import com.shandycasteel.diderot.service.BookService;
import com.shandycasteel.diderot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private CategoryService categoryService;

  // Displays a single Book
  @RequestMapping( path = "/book/show/{id}")
  public String showSingleBook(@PathVariable("id") long id, Model model) {
    Book book = bookService.findById(id);
    model.addAttribute("book", book);

    return "books/show-by-id";
  }

  // New Book form
  @RequestMapping( path = "/book/create")
  public String newBookForm(Model model) {
    model.addAttribute("book", new Book());
    Set<Category> categories = categoryService.getAll();
    model.addAttribute("categories", categories);

    return "books/new";
  }

  // Save details of "book/create" to database
  @RequestMapping(path = "/book", method = RequestMethod.POST)
  public String saveNewBook(Book book) {
    long id = bookService.create(book);

    return "redirect:/books";
  }

  @GetMapping("/book/{id}")
  public String editBookForm(@PathVariable("id") long id, Model model) {
    Book book = bookService.findById(id);
    Set<Category> categories = categoryService.getAll();
    model.addAttribute("allCategories", categories);
    model.addAttribute("book", book);

    return "books/edit";
  }

  // Shows all existing books as list
  @GetMapping("/books")
  public String showAllBooks(Model model) {
    model.addAttribute("books", bookService.getAll());
    model.addAttribute("categories", categoryService.getAll());

    return "books/index";
  }

  @RequestMapping(path = "/book/{id}", method = RequestMethod.POST)
  public String updateBook(@PathVariable("id") long id, Book book) {
    bookService.update(id, book);

    return "redirect:/books";    }

  // Deletes book from database
  @RequestMapping(path = "/book/delete/{id}", method = RequestMethod.GET)
  public String deleteBook(@PathVariable("id") long id) {
    bookService.delete(id);

    return "redirect:/books";
  }

}