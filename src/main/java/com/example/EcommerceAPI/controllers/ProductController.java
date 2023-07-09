package com.example.EcommerceAPI.controllers;

import com.example.EcommerceAPI.models.Product;
import com.example.EcommerceAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
     return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED) ;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product>productList=productService.getProductList();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) {
        Optional<Product>getProduct= productService.getProductById(productId);
        return getProduct.map(value->new ResponseEntity<>(value,HttpStatus.FOUND))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam("category") String category) {
        List<Product>getProducts= productService.getProductsByCategory(category);
        return new ResponseEntity<>(getProducts,HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("productId") Integer productId) {
      Optional<Product>exist = productService.getProductById(productId);
      if (exist.isPresent()){
          productService.deleteProductById(productId);
          return new ResponseEntity<>(HttpStatus.ACCEPTED);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
