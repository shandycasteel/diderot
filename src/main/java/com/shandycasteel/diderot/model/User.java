package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, max=15, message="Your username can be between 5 and 15 characters.")
    @Column(unique = true)
    private String username;

    @NotEmpty(message="This is not a valid email")
    @Email(message="This is not a valid email.")
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min=8, message="Passwords may not be shorter than 8 characters.")
    private String password;

    @NotNull(message="Passwords do not match.")
    @Transient
    private String verifyPassword;

    @PastOrPresent
    private Instant joinDate = Instant.now();

    private int active;

    private Set roles;

    public void checkPassword() {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @ JoinColumn(name = "role_id"))
    public Set getRoles() {
        return roles;
    }

}
