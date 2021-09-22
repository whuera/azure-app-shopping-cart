package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.Checkout;
import com.app.mobilpymes.shoppingcart.entity.Customer;

import java.util.List;

public
interface CheckoutService {
    public
    String createCheckout (Checkout checkout);

    public
    List < Checkout > getAllCheckouts ( );

    public
    List < Checkout > getByCustomer (Customer customer);

    public
    Checkout getCheckout (Long id);
}
