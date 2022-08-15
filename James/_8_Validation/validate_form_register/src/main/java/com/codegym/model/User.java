package com.codegym.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "first_name")
    @NotBlank(message = "Can't blank or empty")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Can't blank or empty")
    private String lastName;

    @Column(name = "user_phone")
    @Pattern(regexp = "^[0-9]{9,10}$",message = "9-10 number and first number is 0")
    private String phone;

    @Column(name = "user_age")
    @Min(value = 18, message = "Must be greater or equal 18 and lower than 100")
    @Max(value = 100, message = "Must be greater or equal 18 and lower than 100")
    private Integer age;

    @Column(name = "user_email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;

    public User() {
    }

    public User(Integer idUser, String firstName, String lastName, String phone, Integer age, String email) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}