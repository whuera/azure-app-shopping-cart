package com.app.mobilpymes.shoppingcart.repository;

import com.app.mobilpymes.shoppingcart.entity.PaymentItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PaymentItemsRepository extends JpaRepository < PaymentItems, Long > {
}
