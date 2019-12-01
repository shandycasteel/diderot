package com.shandycasteel.diderot.contoller;

import com.shandycasteel.diderot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("title", "My Books");

        return "book/index";
    }

}