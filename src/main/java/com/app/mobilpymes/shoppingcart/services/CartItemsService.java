package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.CartItems;
import com.app.mobilpymes.shoppingcart.entity.Customer;

import java.util.List;

/**
 * Service interface for managing cart items.
 * <p>
 * This service provides methods to retrieve and manipulate items within a
 * shopping cart.
 * </p>
 */
public interface CartItemsService {

    /**
     * Retrieves a list of cart items associated with a specific customer.
     *
     * @param customer The customer whose cart items are to be retrieved.
     * @return A list of {@link CartItems} belonging to the customer.
     */
    public List<CartItems> listCartItems(Customer customer);
}
