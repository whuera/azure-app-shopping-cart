package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CustomerRepository;
import com.app.mobilpymes.shoppingcart.services.CustomerService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        if (Objects.isNull(customer)) {
            return null;
        }
        customer.setStatus(ShoppingCartEnum.CUSTOMER_CREATE.type);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (Objects.isNull(customer) || Objects.isNull(customer.getId())) {
            return null;
        }
        Customer customerDB = getCustomer(customer.getId());
        if (Objects.isNull(customerDB)) {
            return null;
        }
        customer.setStatus(ShoppingCartEnum.CUSTOMER_UPDATE.type);
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(long id) {
        Customer customerDB = getCustomer(id);
        if (Objects.isNull(customerDB)) {
            return null;
        }
        customerDB.setStatus(ShoppingCartEnum.CUSTOMER_DELETE.type);
        return customerRepository.save(customerDB);
    }

    @Override
    public Customer getCustomer(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getLatestCustomer() {
        return customerRepository.findTopByOrderByIdDesc();
    }
}
