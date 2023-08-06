package edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class LoginForm {
    @NotNull
    @Email
    @Length(min=5)
    private String email;

    @NotNull
    @Pattern(regexp="^[A-Z][a-z]+\\s[A-Z][a-z]+$")
    private String name;

    @NotNull
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
