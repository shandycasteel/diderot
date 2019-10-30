package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.User;
import com.shandycasteel.diderot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

}
