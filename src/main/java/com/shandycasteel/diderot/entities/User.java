package com.shandycasteel.diderot.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(updatable = false)
  private Long id;

  @Size(min = 5, max = 15, message = "Your username can be between 5 and 15 characters")
  @Column(nullable = false, unique = true)
  @NotEmpty
  private String username;

  @Column(nullable = false, unique = true)
  @NotEmpty
  @Email(message = "{errors.invalid_email}")
  private String email;

  @Column(nullable = false)
  @NotEmpty
  @Size(min = 8, message = "Your password needs to be at least 8 character")
  private String password;

  @PastOrPresent
  private Instant joinDate = Instant.now();

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(
      name = "user_role",
      joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
  private List<Role> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {

    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Instant getJoinDate() {

    return joinDate;
  }

  public void setJoinDate(Instant joinDate) {

    this.joinDate = joinDate;
  }

  public List<Role> getRoles() {

    return roles;
  }

  public void setRoles(List<Role> roles) {

    this.roles = roles;
  }
}