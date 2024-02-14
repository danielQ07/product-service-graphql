package com.appOrders.productservice.controller;

import com.appOrders.productservice.dto.ProductoRequest;
import com.appOrders.productservice.model.Product;
import com.appOrders.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @QueryMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @QueryMapping
    public List<Product> getThreeMoreExpensiveProducts(){
        return productService.getThreeMoreExpensiveProducts();
    }

    @MutationMapping
    public Product saveProduct(@Argument ProductoRequest productoRequest){
        return productService.saveProduct(productoRequest);
    }

    @PostMapping(value = "hello")
    public String Hello(){
        return "hello";
    }

}
