package com.finalYearProject.enterPot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Customer(String firstName, String lastName, String email, String password, String gender, Date birthday, String cardNumber, Date cardExpDate,String addressLineOne, String addressLineTwo, String city, String country, int postalCode,Order... orders){
         this.firstName = firstName;
         this.lastName = lastName;
         this.email = email;
         this.password = password;
         this.gender = gender;
         this.birthday = birthday;
         this.cardNumber = cardNumber;
         this.cardExpDate = cardExpDate;
         this.addressLineOne = addressLineOne;
         this.addressLineTwo = addressLineTwo;
         this.city = city;
         this.country = country;
         this.postalCode = postalCode;
         this.orders = Stream.of(orders).collect(Collectors.toSet());
         this.orders.forEach(x-> x.setCustomer(this));
    }


}
