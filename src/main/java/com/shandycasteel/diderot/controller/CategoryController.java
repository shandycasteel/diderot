package com.shandycasteel.diderot.controller;

import com.shandycasteel.diderot.model.Book;
import com.shandycasteel.diderot.model.Category;
import com.shandycasteel.diderot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  // Returns Form for new Category
  @RequestMapping(path = "/category/create")
  public String newCatForm(Model model) {
    model.addAttribute("category", new Category());

    return "categories/new";
  }

  // Save details of NewCategoryForm to database
  @RequestMapping(path = "/category", method = RequestMethod.POST)
  public String saveNewCategory(Category category) {
    long id = categoryService.create(category);

    return "redirect:/categories";
  }

  @GetMapping("/category/{id}")
  public String editCategoryForm(@PathVariable("id") long id, Model model) {
    Category category = categoryService.findById(id);
    model.addAttribute("category", category);

    return "categories/edit";
  }

  // Shows books by Category
  @GetMapping("/category/books/{id}")
  public String showBooksByCategory(@PathVariable("id") long category_id, Model model) {
    Category category = categoryService.findById(category_id);
    Set<Book> books = category.getBooks();
    model.addAttribute("category", category);
    model.addAttribute("books", books);

    return "categories/show-by-id";
  }

  // View of all existing Categories in database
  @GetMapping("/categories")
  public String showAllCategories(Model model) {
    model.addAttribute("categories", categoryService.getAll());

    return "categories/list";
  }

  // Saves updates to existing Category in database
  @RequestMapping(path = "/category/{id}", method = RequestMethod.POST)
  public String updateCategory(@PathVariable("id") long id, Category category) {
    categoryService.update(id, category);

    return "redirect:/categories";    }

  // Deletes existing Category
  @RequestMapping(path = "/category/delete/{id}", method = RequestMethod.GET)
  public String deleteCategory(@PathVariable("id") long id) {
    categoryService.delete(id);

    return "redirect:/categories";
  }

}