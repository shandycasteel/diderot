package com.shandycasteel.diderot.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable=false)
    private Long id;

    @Size(min=5, max=15, message = "Your username can be between 5 and 15 characters")
    @Column(nullable=false, unique=true)
    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @PastOrPresent
    private Instant joinDate = Instant.now();

    @ManyToMany
    private Set<Role> roles;

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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Instant getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Instant joinDate) {
        this.joinDate = joinDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
