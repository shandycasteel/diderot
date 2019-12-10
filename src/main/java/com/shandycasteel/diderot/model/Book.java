package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
        joinColumns = { @JoinColumn(name = "book_id") },
        inverseJoinColumns = { @JoinColumn(name = "category_id") })
    private Set<Locale.Category> categories = new HashSet<>();

    @Column(name = "Year")
    @DateTimeFormat(pattern = "yyyy")
    private Date dateField;

    @Lob
    @NotEmpty
    private String description;


    public Set<Locale.Category> getCategories() {
      return categories;
    }

    public void setCategories(Set<Locale.Category> categories) {
      this.categories = categories;
    }

  }