package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.CartItems;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CartItemsRepository;
import com.app.mobilpymes.shoppingcart.services.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link CartItemsService} interface.
 * <p>
 * This class provides the business logic for managing cart items, interacting
 * with the {@link CartItemsRepository}.
 * </p>
 */
@Service
public class CartItemsServiceImpl implements CartItemsService {

    @Autowired
    private CartItemsRepository cartItemsRepository;

    /**
     * Retrieves a list of cart items associated with a specific customer.
     * <p>
     * This method delegates the retrieval to the
     * {@link CartItemsRepository#findByCustomer(Customer)} method.
     * </p>
     *
     * @param customer The customer whose cart items are to be retrieved.
     * @return A list of {@link CartItems} belonging to the customer.
     */
    @Override
    public List<CartItems> listCartItems(Customer customer) {
        return cartItemsRepository.findByCustomer(customer);
    }
}
