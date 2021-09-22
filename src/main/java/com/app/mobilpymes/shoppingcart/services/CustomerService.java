package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.Customer;

import java.util.List;

public
interface CustomerService {
    public
    Customer createCustomer (Customer customer);

    public
    Customer updateCustomer (Customer customer);

    public
    Customer deleteCustomer (long id);

    public
    Customer getCustomer (Long id);

    public
    List < Customer > listAllCustomer ( );

}
