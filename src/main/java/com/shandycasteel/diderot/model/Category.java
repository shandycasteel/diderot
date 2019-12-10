package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @Column(name ="cat_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  @NotEmpty
  private String name;

  @ManyToMany(mappedBy = "categories")
  private Set<Book> books;

  public Category(@NotEmpty String name) {
    this.name = name;
  }

}