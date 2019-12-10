package com.shandycasteel.diderot.controller;

import com.shandycasteel.diderot.model.User;
import com.shandycasteel.diderot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
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
    User userNameExists = userServiceImpl.findUserByName (user.getName());
    User userEmailExists = userServiceImpl.findUserByEmail(user.getEmail());

    if (userNameExists != null) {
      bindingResult
          .rejectValue("name", "error.user",
              "There is already a user registered with that username");
    }

    if (userEmailExists != null) {
      bindingResult
          .rejectValue("email", "error.user",
              "There is already a user registered with the email provided");
    }

    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("registration");
      return modelAndView;
    }

    userServiceImpl.saveUser(user);
    modelAndView.addObject("successMessage", "User has been registered successfully");
    modelAndView.addObject("user", new User());
    modelAndView.setViewName("redirect:/login");

    return modelAndView;
  }

  @RequestMapping(value="/user/home", method = RequestMethod.GET)
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userServiceImpl.findUserByEmail(auth.getName());
    modelAndView.addObject("user", user);
    modelAndView.setViewName("/user/home");
    return modelAndView;
  }

  @RequestMapping(value="/logout")
  public String logout() {
    return "redirect:/login";
  }

  @PostMapping("/delete")
  public String deleteUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userServiceImpl.findUserByEmail(auth.getName());
    userServiceImpl.deleteUser(user);

    return logout();
  }

}