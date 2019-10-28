package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    private Date publicationDate;

    private String genre;

}
