package com.example.EcommerceAPI.services;

import com.example.EcommerceAPI.models.Address;
import com.example.EcommerceAPI.models.User;
import com.example.EcommerceAPI.repositories.AddressDao;
import com.example.EcommerceAPI.repositories.UserDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressDao addressDao;
    @Autowired
    private UserDao userDao;

    public Address createAddress(Address address) {
        User user = userDao.findById(address.getUser().getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        address.setUser(user);
        return addressDao.save(address);
    }

    public Optional<Address> getAddressById(Integer addressId) {
        return addressDao.findById(addressId);
    }
}
