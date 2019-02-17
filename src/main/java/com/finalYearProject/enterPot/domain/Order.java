package com.finalYearProject.enterPot.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Data

@Entity
@Table(name = "Item_Order")
public class Order {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @Size(min=1, max=10)
    private int quantity;

    @Column(precision = 10,scale = 2)
    private BigDecimal total;

    @NotNull @Max(50)
    private String shippingMode;

    @NotNull @Max(20)
    private String status;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Future
    private Date estimatedDeliveryDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private  Date orderedDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private  Date shippedDate;

    @NotNull
    private  String location;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToOne
    @JoinColumn
    private Item item;

    public Order(int quantity, BigDecimal total, String shippingMode, String status, Date estimatedDeliveryDate, Date orderedDate, Date shippedDate, String location){
        this.quantity = quantity;
        this.total = total;
        this.shippingMode = shippingMode;
        this.status = status;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.orderedDate = orderedDate;
        this.shippedDate = shippedDate;
        this.location = location;
    }
}
