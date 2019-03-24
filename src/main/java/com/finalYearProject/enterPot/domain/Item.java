package com.finalYearProject.enterPot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "orders")

@Entity
@Table(name = "Item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 10, scale = 2)
    @NotNull
    private BigDecimal price;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String models;


}
