package com.app.mobilpymes.shoppingcart.repository;

import com.app.mobilpymes.shoppingcart.entity.Category;
import com.app.mobilpymes.shoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface ProductRepository extends JpaRepository < Product, Long > {
    public
    List < Product > findByCategory (Category category);
}
