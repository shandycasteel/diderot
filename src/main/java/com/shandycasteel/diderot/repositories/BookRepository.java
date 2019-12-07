package com.shandycasteel.diderot.repositories;

import com.shandycasteel.diderot.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}