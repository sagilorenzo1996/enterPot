package com.finalYearProject.enterPot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "orders")

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 40)
    private String firstName;


    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 1, max = 64)
    private String password;

    @NotNull
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    @Past
    private Date birthday;

    @NotNull
    @Size(min = 16, max = 19)
    private String cardNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date cardExpDate;

    @NotNull
    @Size(min = 1, max = 50)
    private String addressLineOne;

    @Size(min = 1, max = 80)
    private String addressLineTwo;

    @NotNull
    @Size(min = 1, max = 50)
    private String city;

    @NotNull
    @Size(min = 1, max = 40)
    private String country;

    @NotNull
    @Size(min = 1, max = 8)
    private int postalCode;

}
