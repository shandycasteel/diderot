package com.shandycasteel.diderot.repository;

import com.shandycasteel.diderot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}