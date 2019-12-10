package com.shandycasteel.diderot.service;

import com.shandycasteel.diderot.model.Category;
import com.shandycasteel.diderot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Set<Category> getAll(){
    Set<Category> categorySet = new HashSet<>();
    categoryRepository.findAll().iterator().forEachRemaining(categorySet::add);

    return categorySet;
  }

  @Override
  public Category findById(Long catId){
    Optional<Category> categoryOptional = categoryRepository.findById(catId);

    if (!categoryOptional.isPresent()) {
      throw new RuntimeException("Category Not Found!");
    }

    return categoryOptional.get();
  }

  @Override
  public void delete(Long catId){
    categoryRepository.deleteById(catId);
  }

  @Override
  public Long create(Category categoryDetails){
    categoryRepository.save(categoryDetails);

    return categoryDetails.getId();
  }

  @Override
  public void update(Long catId, Category categoryDetails){
    Category currentCat = findById(catId);
    currentCat.setName(categoryDetails.getName());
    categoryRepository.save(currentCat);
  }

}
