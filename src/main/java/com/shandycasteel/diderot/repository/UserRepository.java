package com.shandycasteel.diderot.repository;

import com.shandycasteel.diderot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}