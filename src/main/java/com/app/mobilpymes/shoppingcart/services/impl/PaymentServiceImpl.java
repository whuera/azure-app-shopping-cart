package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.PaymentItems;
import com.app.mobilpymes.shoppingcart.repository.PaymentItemsRepository;
import com.app.mobilpymes.shoppingcart.services.PaymentService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public
class PaymentServiceImpl implements PaymentService {

    private
    final PaymentItemsRepository paymentItemsRepository;

    @Override
    public
    List < PaymentItems > listAllCards ( ) {
        return paymentItemsRepository.findAll ( );
    }

    @Override
    public
    PaymentItems getCardById (Long id) {
        return paymentItemsRepository.getById ( id );
    }

    @Override
    public
    PaymentItems createPaymentCard (PaymentItems paymentItems) {
        if ( null == paymentItems ) {
            return null;
        }
        return paymentItemsRepository.save ( paymentItems );
    }

    @Override
    public
    PaymentItems updatePaymentCard (PaymentItems paymentItems) {
        PaymentItems paymentItemsDB = getCardById ( paymentItems.getId ( ) );
        if ( null == paymentItemsDB ) {
            return null;
        }
        paymentItemsDB.setNumberCard ( paymentItems.getNumberCard ( ) );
        paymentItemsDB.setCvv ( paymentItems.getCvv ( ) );
        paymentItemsDB.setDateExpired ( paymentItems.getDateExpired ( ) );
        paymentItemsDB.setTypeCard ( paymentItems.getTypeCard ( ) );
        paymentItemsDB.setCustomer ( paymentItems.getCustomer ( ) );
        return paymentItemsRepository.save ( paymentItemsDB );
    }

    @Override
    public
    PaymentItems deletePaymentCard (Long idCard) {
        if ( !idCard.equals ( null ) ) {
            PaymentItems cardCustomer = getCardById ( idCard );
            cardCustomer.setStatusCard ( ShoppingCartEnum.CARD_INACTIVE.type );
            return paymentItemsRepository.save ( cardCustomer );
        } else {
            return null;
        }
    }
}
