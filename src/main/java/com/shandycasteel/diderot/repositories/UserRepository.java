package com.shandycasteel.diderot.repositories;

import com.shandycasteel.diderot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);
}