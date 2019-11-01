package com.shandycasteel.diderot.contoller;

import com.shandycasteel.diderot.model.User;
import com.shandycasteel.diderot.repository.UserRepository;
import com.shandycasteel.diderot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    private String pageTitle = "Diderot: Join today!";

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", pageTitle);
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User newUser, Errors errors) {

        model.addAttribute("title", pageTitle);
        model.addAttribute("user", newUser);

        if (errors.hasErrors()) {
            model.addAttribute("title", pageTitle);
            return "index";
        }

        userRepository.save(newUser);
        return "redirect:/";
    }

}