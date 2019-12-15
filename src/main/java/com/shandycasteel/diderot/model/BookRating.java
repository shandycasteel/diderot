package com.shandycasteel.diderot.model;

import javax.persistence.*;

@Entity
public class BookRating {

  @EmbeddedId
  BookRatingKey id;

  @ManyToOne
  @MapsId("user_id")
  @JoinColumn(name = "user_id")
  User user;

  @ManyToOne
  @MapsId("book_id")
  @JoinColumn(name = "book_id")
  Book book;

  double rating;
}
