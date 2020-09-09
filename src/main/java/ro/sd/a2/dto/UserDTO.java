package ro.sd.a2.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDTO {
    @NotEmpty(message="Username must have between 1 and 50 characters")
    private String username;

    @NotEmpty
    private String password;

    @Email
    @NotEmpty(message="Email does not respect email format : example@example.com")
    private String email;

    @NotEmpty(message="First Name must have between 1 and 45 characters")
    private String name;

    @NotEmpty(message="Last Name must have between 1 and 45 characters")
    private String surname;

    @NotNull
    private Date birthdate;

    @NotEmpty
    private String address;


    public UserDTO(){}

    public UserDTO(String username, String surname,String password, String email, String name,  Date birthdate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
