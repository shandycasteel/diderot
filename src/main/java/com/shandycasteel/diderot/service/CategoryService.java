package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.Category;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CategoryService extends CrudService<Category, Long> {

  // Gets all categories
  Set<Category> getAll();

  // Finds a Category by ID
  Category findById(Long catId);

  // Create and insert new a Category
  Long create(Category categoryDetails);

  // Update a Category
  void update(Long catId, Category categoryDetails);

  // Delete a Category
  void delete(Long catId);

}