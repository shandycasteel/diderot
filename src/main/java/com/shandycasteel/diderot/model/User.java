package com.shandycasteel.diderot.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int id;

  @Column(name = "user_id", nullable = false, unique = true)
  @Size(min = 5, max = 15, message = "*Your username can be between 5 and 15 characters")
  @NotEmpty(message = "*Please provide a username")
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  @NotEmpty(message = "*An email address is required")
  @Email(message = "*Please provide a valid email address")
  private String email;

  @Column(name = "password", nullable = false)
  @NotEmpty(message = "*A password is required")
  @Size(min = 8, message = "*Your password needs to be at least 8 character")
  private String password;

  @PastOrPresent
  private Instant joinDate = Instant.now();

  @Column(name = "active")
  private int active;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public List<Role> getRoles() {

    return roles;
  }

  public void setRoles(List<Role> roles) {

    this.roles = roles;
  }
}