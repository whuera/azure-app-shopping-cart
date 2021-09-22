package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CustomerRepository;
import com.app.mobilpymes.shoppingcart.services.CustomerService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public
class CustomerServiceImpl implements CustomerService {

    private
    final CustomerRepository customerRepository;

    @Override
    public
    Customer createCustomer (Customer customer) {
        if ( null == customer ) {
            return null;
        }
        customer.setStatus ( ShoppingCartEnum.CUSTOMER_CREATE.type );
        return customerRepository.save ( customer );
    }

    @Override
    public
    Customer updateCustomer (Customer customer) {
        Customer customerDB = getCustomer ( customer.getId ( ) );
        if ( null == customerDB ) {
            return null;
        }
        customer.setStatus ( ShoppingCartEnum.CUSTOMER_UPDATE.type );
        return customerRepository.save ( customer );
    }

    @Override
    public
    Customer deleteCustomer (long id) {
        Customer customerDB = getCustomer ( id );
        if ( null == customerDB ) {
            return null;
        }
        customerDB.setStatus ( ShoppingCartEnum.CUSTOMER_DELETE.type );
        return customerRepository.save ( customerDB );
    }

    @Override
    public
    Customer getCustomer (Long id) {
        return customerRepository.findById ( id ).orElse ( null );
    }

    @Override
    public
    List < Customer > listAllCustomer ( ) {
        return customerRepository.findAll ( );
    }
}
