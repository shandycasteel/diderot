package com.shandycasteel.diderot.contoller;

import com.shandycasteel.diderot.model.User;
import com.shandycasteel.diderot.repository.UserRepository;
import com.shandycasteel.diderot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("community")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

       // model.addAttribute("users", UserRepository.getAll());
       // model.addAttribute("title", "Users");
        return "user/index";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable("username") long id) {
        model.addAttribute("title", "User Profile");
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "user/user-detail";
    }

}