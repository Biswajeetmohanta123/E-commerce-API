package com.example.EcommerceAPI.services;


import com.example.EcommerceAPI.models.Product;
import com.example.EcommerceAPI.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
@Autowired
    ProductDao productDao;

    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    public List<Product> getProductList() {
        return productDao.findAll();
    }


    public Optional<Product> getProductById(Integer productId) {
        return productDao.findById(productId);
    }

    public List<Product> getProductsByCategory(String category) {
        return productDao.findByCategory(category);
    }

    public void deleteProductById(Integer productId) {
        productDao.deleteById(productId);
    }
}
