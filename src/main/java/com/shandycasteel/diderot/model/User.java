package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long id;

    @NotNull
    @Size(min=5, max=15, message="Your username can be between 5 and 15 characters.")
    @Column(unique = true)
    private String username;

    @NotEmpty(message="This is not a valid email")
    @Email(message="This is not a valid email.")
    private String email;

    @NotNull
    @Size(min=8, message="Passwords may not be shorter than 8 characters.")
    private String password;

    @NotNull(message="Passwords do not match.")
    @Transient
    private String verifyPassword;

    @PastOrPresent
    private Instant joinDate = Instant.now();

    public void checkPassword() {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

}
