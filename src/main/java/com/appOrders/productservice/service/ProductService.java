package com.appOrders.productservice.service;

import com.appOrders.productservice.dto.ProductoRequest;
import com.appOrders.productservice.model.Category;
import com.appOrders.productservice.model.Product;
import com.appOrders.productservice.repository.CategoryRepository;
import com.appOrders.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getThreeMoreExpensiveProducts(){
        return productRepository.getThreeMoreExpensive();
    }

    public Product saveProduct(ProductoRequest productoRequest){
        Category category= categoryRepository.findById(productoRequest.categoryId()).orElseThrow(null);
        return productRepository.save(Product.builder()
                        .name(productoRequest.name())
                        .price(productoRequest.price())
                        .quantity(productoRequest.quantity())
                        .category(category)
                .build());
    }
}
