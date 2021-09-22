package com.app.mobilpymes.shoppingcart.repository;

import com.app.mobilpymes.shoppingcart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface CustomerRepository extends JpaRepository < Customer, Long > {
}
