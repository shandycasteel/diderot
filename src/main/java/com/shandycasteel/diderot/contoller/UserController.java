package com.shandycasteel.diderot.contoller;

import com.shandycasteel.diderot.model.User;
import com.shandycasteel.diderot.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("community")
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

       // model.addAttribute("users", UserRepository.getAll());
       // model.addAttribute("title", "Users");
        return "user/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable("id") int id) {
        model.addAttribute("title", "User Profile");
        //User user = UserRepository..getById(id);
        //model.addAttribute("user", user);
        return "user/user-detail";
    }

}