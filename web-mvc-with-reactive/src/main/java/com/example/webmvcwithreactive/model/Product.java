package com.example.webmvcwithreactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "sku")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    String sku;

    String name;
}
