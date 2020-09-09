package ro.sd.a2.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name="user")
public class User {

    @Id

    private String user_id;

    @Column

    private String role;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Date birthdate;

    @Column

    private String address;

    @Column

    private Integer age;

    @Column
    private String username;


    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Date registration_date;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> accounts;

    public User(String name) {
        this.name=name;
    }

    public User() {
    }


    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String user_type) {
        this.role = user_type;
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

    public void setBirthday_date(Date birthday_date) {

        this.birthdate = birthday_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge() {
        Date now =  new Date();
        long millisDiff = Math.abs(now.getTime() - this.birthdate.getTime());
        int age = (int) TimeUnit.DAYS.convert(millisDiff, TimeUnit.MILLISECONDS)/365;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date() {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Date now =  new Date();
        this.registration_date = now;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
