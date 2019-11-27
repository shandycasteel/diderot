package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}