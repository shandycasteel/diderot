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
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @NotNull
    @Size(min=5, max=15, message = "Your username can be between 5 and 15 characters")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "This is not a valid email")
    @Email(message = "This is not a valid email")
    private String email;

    @NotNull
    @Size(min=6, max=64, message = "Passwords can be between 6 and 64 characters")
    private String password;

    @Transient
    @NotNull(message="Passwords do not match")
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
