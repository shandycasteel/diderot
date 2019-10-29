package com.shandycasteel.diderot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min=5, max=15, message = "Your username can be between 5 and 15 characters")
    private String username;

    @Email(message = "This is not a valid email")
    private String email;

    @NotNull
    @Size(min=6, max=64, message = "Passwords can be between 6 and 64 characters")
    private String password;

    @NotNull(message="Passwords do not match")
    private String verifyPassword;

    private Instant joinDate = Instant.now();

    private void checkPassword() {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

}
