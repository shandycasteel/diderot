package com.shandycasteel.diderot.service;

import java.util.Set;

public interface CrudService<T, ID> {

  // Gets all Objects from database
  Set<T> getAll();

  // Finds an Object by ID
  T findById(ID id);

  // Creates new Object and saves it in database
  Long create(T tDetails);

  // Updates Object from database
  void update(ID id, T tDetails);

  // deletes Object from database
  void delete(ID id);

}
