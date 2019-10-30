package com.shandycasteel.diderot.repository;

import com.shandycasteel.diderot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}