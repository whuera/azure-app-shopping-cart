package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.CartItems;
import com.app.mobilpymes.shoppingcart.entity.Customer;

import java.util.List;

public
interface CartItemsService {
    public
    List < CartItems > listCartItems (Customer customer);
}
