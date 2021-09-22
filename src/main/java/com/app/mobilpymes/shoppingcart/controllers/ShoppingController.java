package com.app.mobilpymes.shoppingcart.controllers;

import com.app.mobilpymes.shoppingcart.entity.CartItems;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.services.CartItemsService;
import com.app.mobilpymes.shoppingcart.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shopping")
@CrossOrigin
public
class ShoppingController {

    @Autowired
    private
    CartItemsService cartItemsService;

    @Autowired
    private
    CustomerService customerService;

    @GetMapping("/cartitems")
    public
    ResponseEntity < List < CartItems > > getShoppingCart (@RequestParam(name = "customerId", required = true) Long customerId) {
        Customer customerBD = customerService.getCustomer ( customerId );
        return ResponseEntity.ok ( cartItemsService.listCartItems ( customerBD ) );
    }

}
