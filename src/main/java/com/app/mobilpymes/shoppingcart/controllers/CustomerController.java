package com.app.mobilpymes.shoppingcart.controllers;

import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.services.CustomerService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public
class CustomerController {

    @Autowired
    private
    CustomerService customerService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("create")
    public
    ResponseEntity < Customer > createCustomer (@Valid @RequestBody Customer customer, BindingResult result) {
        if ( result.hasErrors ( ) ) {
            throw new ResponseStatusException ( HttpStatus.BAD_REQUEST, ShoppingCartHelper.formatMessage ( result ) );
        }
        Customer customerCreate = customerService.createCustomer ( customer );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( customerCreate );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/customers")
    public
    ResponseEntity < List < Customer > > getAllCustomers ( ) {
        return ResponseEntity.ok ( customerService.listAllCustomer ( ) );
    }

    @PutMapping(value = "/{id}")
    public
    ResponseEntity < Customer > updateCustomer (@PathVariable("id") Long id, @RequestBody Customer customer) {
        customer.setId ( id );
        Customer customerDB = customerService.updateCustomer ( customer );

        if ( customerDB == null ) {
            return ResponseEntity.notFound ( ).build ( );
        }
        return ResponseEntity.ok ( customerDB );
    }
}
