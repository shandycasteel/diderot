package com.shandycasteel.diderot.contoller;

import com.shandycasteel.diderot.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("title", "My Books");

        return "book/index";
    }

}