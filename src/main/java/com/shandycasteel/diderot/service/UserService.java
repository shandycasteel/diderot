package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.User;

public interface UserService {

  public User findUserByEmail(String email);
  public void saveUser(User user);
}
