package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.CartItems;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CartItemsRepository;
import com.app.mobilpymes.shoppingcart.services.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class CartItemsServiceImpl implements CartItemsService {

    @Autowired
    private
    CartItemsRepository cartItemsRepository;

    @Override
    public
    List < CartItems > listCartItems (Customer customer) {
        return cartItemsRepository.findByCustomer ( customer );
    }
}
