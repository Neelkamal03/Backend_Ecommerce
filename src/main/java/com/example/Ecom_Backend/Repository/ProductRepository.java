package com.example.Ecom_Backend.Repository;

import com.example.Ecom_Backend.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {

    @Query("SELECT p from Products p WHERE "+
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR "+
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR "+
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR "+
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword ,'%'))")
    public List<Products> searchProducts(String keyword);
}
