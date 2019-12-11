package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
        joinColumns = {@JoinColumn(name = "book_id")},
        inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category>categories = new HashSet<>();

    @Column(name = "year")
    @DateTimeFormat(pattern = "yyyy")
    private Date dateField;

    @Lob
    @NotEmpty
    @Type(type = "org.hibernate.type.TextType")
    private String description;

}