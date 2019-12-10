package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int id;

  @Column(name = "name", nullable = false, unique = true)
  @Size(min = 5, max = 15, message = "*Your community name can be between 5 and 15 characters")
  @NotEmpty(message = "*Please provide a community name")
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  @NotEmpty(message = "*An email address is required")
  @Email(message = "*Please provide a valid email address")
  private String email;

  @Column(name = "password", nullable = false)
  @NotEmpty(message = "*A password is required")
  @Size(min = 8, message = "*Your password needs to be at least 8 characters")
  private String password;

  @Transient
  @NotNull(message="Your passwords do not match")
  private String passwordConfirm;

  @PastOrPresent
  private Instant joinDate = Instant.now();

  @Column(name = "active")
  private int active;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  private void matchPassword() {
    if (password != null && passwordConfirm != null && !password.equals(passwordConfirm)) {
      passwordConfirm = null;
    }
  }

  public void setPasswordConfirm(String passwordConfirm)  {
    this.passwordConfirm = passwordConfirm;
    matchPassword();
  }

}