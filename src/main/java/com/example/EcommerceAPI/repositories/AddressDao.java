package com.example.EcommerceAPI.repositories;

import com.example.EcommerceAPI.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address,Integer> {
}
