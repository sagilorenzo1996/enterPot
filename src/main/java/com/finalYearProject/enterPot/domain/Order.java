package com.finalYearProject.enterPot.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data

@Entity
@Table(name = "Item_Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int quantity;

    @Column(precision = 10, scale = 2)
    private BigDecimal total;

    @NotNull
    @Size(min = 1, max = 50)
    private String shippingMode;

    @NotNull
    @Size(min = 1, max = 20)
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date estimatedDeliveryDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date orderedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shippedDate;

    @NotNull
    private String location;

    @NotNull
    private Long customerId;

    @NotNull
    private Long itemId;

    private String country;

    private Float lat;

    private Float lng;



}
