package com.finalYearProject.enterPot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "orders")

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @Size(min=2, max=40)
    private String firstName;


    @Size(min=2, max=50)
    private String lastName;

    @NotEmpty @Email
    private String email;

    @NotNull @Min(8) @Max(40)
    private String password;

    @NotNull
    private String gender;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull @Past
    private Date birthday;

    @NotNull @Min(16) @Max(19)
    private String cardNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date cardExpDate;

    @NotNull @Max(50)
    private String addressLineOne;

    @Max(80)
    private String addressLineTwo;

    @NotNull @Max(50)
    private String city;

    @NotNull @Max(40)
    private String country;

    @NotNull @Max(8)
    private int postalCode;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

}
