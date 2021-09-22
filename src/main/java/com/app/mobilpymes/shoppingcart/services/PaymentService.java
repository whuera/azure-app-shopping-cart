package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.PaymentItems;

import java.util.List;

public
interface PaymentService {
    public
    List < PaymentItems > listAllCards ( );

    public
    PaymentItems getCardById (Long id);

    public
    PaymentItems createPaymentCard (PaymentItems paymentItems);

    public
    PaymentItems updatePaymentCard (PaymentItems paymentItems);

    public
    PaymentItems deletePaymentCard (Long idCard);

}
