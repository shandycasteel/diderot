package com.shandycasteel.diderot.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class BookCollectionKey {

  @Column(name = "user_id")
  Long userId;

  @Column(name = "book_id")
  Long bookId;

  public BookCollectionKey(Long userId, Long bookId) {
    this.userId = userId;
    this.bookId = bookId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BookCollectionKey)) return false;
    BookCollectionKey that = (BookCollectionKey) o;
    return Objects.equals(getUserId(), that.getUserId()) &&
        Objects.equals(getBookId(), that.getBookId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserId(), getBookId());
  }

}
