package com.shandycasteel.diderot.controller;

import com.shandycasteel.diderot.model.User;
import com.shandycasteel.diderot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
  public ModelAndView login(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
  }


  @RequestMapping(value="/registration", method = RequestMethod.GET)
  public ModelAndView registration(){
    ModelAndView modelAndView = new ModelAndView();
    User user = new User();
    modelAndView.addObject("user", user);
    modelAndView.setViewName("registration");
    return modelAndView;
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView();
    User userExists = userServiceImpl.findUserByEmail(user.getEmail());
    if (userExists != null) {
      bindingResult
          .rejectValue("email", "error.user",
              "There is already a user registered with the email provided");
    }
    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("registration");
    } else {
      userServiceImpl.saveUser(user);
      modelAndView.addObject("successMessage", "User has been registered successfully");
      modelAndView.addObject("user", new User());
      modelAndView.setViewName("registration");

    }
    return modelAndView;
  }

  @RequestMapping(value="/admin/home", method = RequestMethod.GET)
  public ModelAndView home(){
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userServiceImpl.findUserByEmail(auth.getName());
    modelAndView.addObject("userName", "Welcome " + user.getName() + " (" + user.getEmail() + ")");
    modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
    modelAndView.setViewName("admin/home");
    return modelAndView;
  }

}