package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.Checkout;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CheckoutRepository;
import com.app.mobilpymes.shoppingcart.services.CheckoutService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public
class CheckoutServiceImpl implements CheckoutService {

    private final
    CheckoutRepository checkoutRepository;

    @Override
    public
    String createCheckout (Checkout checkout) {
        Checkout checkoutCreate = checkoutRepository.save ( checkout );
        if ( null == checkoutCreate ) {
            return ShoppingCartEnum.CHECKOUT_ERROR.type;
        }
        return ShoppingCartEnum.CHECKOUT_SUCCESS.type;
    }

    @Override
    public
    List < Checkout > getAllCheckouts ( ) {
        return checkoutRepository.findAll ( );
    }

    @Override
    public
    List < Checkout > getByCustomer (Customer customer) {
        return checkoutRepository.findByCustomer ( customer );
    }

    @Override
    public
    Checkout getCheckout (Long id) {
        return checkoutRepository.getById ( id );
    }
}
