package com.example.EcommerceAPI.repositories;


import com.example.EcommerceAPI.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(String category);
}
