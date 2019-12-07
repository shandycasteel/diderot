package com.shandycasteel.diderot.servicies;

import com.shandycasteel.diderot.entities.User;

public interface UserService {

  void save(User user);

  User findByUsername(String username);
}