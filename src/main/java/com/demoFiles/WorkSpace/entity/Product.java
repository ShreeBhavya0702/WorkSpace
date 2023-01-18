package com.demoFiles.WorkSpace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Product_Table")
public class Product {
    @Id
    @GeneratedValue
    int id;
    String name;
    int quantity;
    double price;

}
