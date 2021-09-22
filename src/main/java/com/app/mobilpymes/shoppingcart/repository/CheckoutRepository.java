package com.app.mobilpymes.shoppingcart.repository;

import com.app.mobilpymes.shoppingcart.entity.Checkout;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface CheckoutRepository extends JpaRepository < Checkout, Long > {
    List < Checkout > findByCustomer (Customer customer);
}
