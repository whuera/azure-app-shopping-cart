package com.app.mobilpymes.shoppingcart.controllers;

import com.app.mobilpymes.shoppingcart.entity.Checkout;
import com.app.mobilpymes.shoppingcart.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/checkout")
@CrossOrigin
public
class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/checkouts")
    public
    ResponseEntity < List < Checkout > > getAllCheckouts ( ) {
        List < Checkout > checkoutList = checkoutService.getAllCheckouts ( );
        if ( checkoutList.size ( ) > 0 ) {
            return ResponseEntity.ok ( checkoutService.getAllCheckouts ( ) );
        } else {
            return ResponseEntity.noContent ( ).build ( );
        }

    }

    @PostMapping
    public
    String createCheckout (@Valid @RequestBody Checkout checkout, BindingResult result) {
        return checkoutService.createCheckout ( checkout );
    }
}
