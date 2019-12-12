package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @Column(name ="cat_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @NotEmpty
  private String name;

  @ManyToMany(mappedBy = "categories")
  private Set<Book> books;

}