package com.mahesh101.Restaurant.Management.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Restaurant {

    private @Id @GeneratedValue Long ID;
    private String dishName;
    private int dishPrice,tableNo;

    public Restaurant(String dishName, int dishPrice, int tableNo) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.tableNo = tableNo;
    }
}
