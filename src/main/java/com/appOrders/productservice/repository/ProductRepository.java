package com.appOrders.productservice.repository;

import com.appOrders.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    @Query(value = "CALL getThreeMoreExpensive();", nativeQuery = true)
    public List<Product> getThreeMoreExpensive();
}
