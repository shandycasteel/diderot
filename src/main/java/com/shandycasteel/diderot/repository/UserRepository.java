package com.shandycasteel.diderot.repository;

import com.shandycasteel.diderot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String name);
  User findByEmail(String email);
}