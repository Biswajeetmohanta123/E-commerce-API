package com.example.EcommerceAPI.services;

import com.example.EcommerceAPI.models.Address;
import com.example.EcommerceAPI.models.Order;
import com.example.EcommerceAPI.models.Product;
import com.example.EcommerceAPI.models.User;
import com.example.EcommerceAPI.repositories.AddressDao;
import com.example.EcommerceAPI.repositories.OrderDao;
import com.example.EcommerceAPI.repositories.ProductDao;
import com.example.EcommerceAPI.repositories.UserDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private AddressDao addressDao;

    public Order createOrder(Integer userId, Integer productId, Integer addressId, Integer productQuantity) {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));

        Product product = productDao.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + " not found"));

        Address address = addressDao.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address with id " + addressId + " not found"));

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setAddress(address);
        order.setProductQuantity(productQuantity);
        return orderDao.save(order);
    }

    public Optional<Order> getOrderById(Integer orderId) {
        return orderDao.findById(orderId);
    }
}
