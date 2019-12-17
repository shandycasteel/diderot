package com.shandycasteel.diderot.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

  private double rating;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String userReview;

  public BookRating(BookRatingKey id, User user, Book book, double rating, String userReview) {
    this.id = id;
    this.user = user;
    this.book = book;
    this.rating = rating;
    this.userReview = userReview;
  }

  public BookRatingKey getId() {
    return id;
  }

  public void setId(BookRatingKey id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public String getUserReview() {
    return userReview;
  }

  public void setUserReview(String userReview) {
    this.userReview = userReview;
  }

}
