package com.example.EcommerceAPI.controllers;


import com.example.EcommerceAPI.models.Address;
import com.example.EcommerceAPI.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/addresses")

public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address addressObj=addressService.createAddress(address);
        return new ResponseEntity<>(addressObj,HttpStatus.CREATED);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddress(@PathVariable("addressId") Integer addressId) {
        Optional<Address> addressObj= addressService.getAddressById(addressId);
        return addressObj.map(value->new ResponseEntity<>(value,HttpStatus.FOUND))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
