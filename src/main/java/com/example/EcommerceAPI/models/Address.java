package com.example.EcommerceAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer addressId;
    private String name;
    private String landmark;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String zipCode;
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
