package com.shandycasteel.diderot.web;

import com.shandycasteel.diderot.entities.Book;
import com.shandycasteel.diderot.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping(".home")
  public String home(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "userhome";
  }

  @PostMapping("/messages")
  public String saveMessage(Book book) {}
}
