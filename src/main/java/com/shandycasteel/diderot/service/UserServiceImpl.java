package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.Role;
import com.shandycasteel.diderot.model.User;
import com.shandycasteel.diderot.repository.RoleRepository;
import com.shandycasteel.diderot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service("userService")
public class UserServiceImpl implements UserService{

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository,
                         RoleRepository roleRepository,
                         BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public User findUserByName(String name) {
    return userRepository.findByName(name);
  }

  @Override
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(1);
    Role userRole = roleRepository.findByRole("USER");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    userRepository.save(user);
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }

}