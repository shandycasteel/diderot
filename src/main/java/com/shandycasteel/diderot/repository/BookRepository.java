package com.shandycasteel.diderot.repository;

import com.shandycasteel.diderot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {

}