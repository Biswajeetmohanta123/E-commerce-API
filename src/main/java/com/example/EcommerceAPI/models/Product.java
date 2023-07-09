package com.example.EcommerceAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer productId;

    private String productName;
    private Integer productPrice;
    private String productDescription;

  //  @Enumerated(EnumType.STRING)
    private String category;
    private String productBrand;
}
