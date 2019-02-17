package com.finalYearProject.enterPot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "orders")

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @Column(precision = 10,scale = 2)
    private BigDecimal price;

    @NotNull @Max(200)
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String models;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<Order> orders;

    public Item(BigDecimal price, String name, String description, String models,Order... orders){
        this.price = price;
        this.name = name;
        this.description = description;
        this.models = models;
        this.orders = Stream.of(orders).collect(Collectors.toSet());
        this.orders.forEach(x-> x.setItem(this));
    }


}
