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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Añadidos para logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/api/customer")
@CrossOrigin
public
class CustomerController {
    // Logger SLF4J
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private
    CustomerService customerService;

    @PostMapping("create")
    public
    ResponseEntity < Customer > createCustomer (@Valid @RequestBody Customer customer, BindingResult result) {
        if ( result.hasErrors ( ) ) {
            throw new ResponseStatusException ( HttpStatus.BAD_REQUEST, ShoppingCartHelper.formatMessage ( result ) );
        }
        Customer customerCreate = customerService.createCustomer ( customer );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( customerCreate );
    }

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
    @GetMapping("/latest")
    public ResponseEntity<Map<String, Object>> getLatestCustomer() {
        Map<String, Object> result = new HashMap<>();

        Customer latestCustomer = customerService.getLatestCustomer();

        if (latestCustomer == null) {
            logger.warn("GET /api/customer/latest - no customer found");
            result.put("message", "No customer found");
            result.put("success", false);
            result.put("data", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }

        // Log de éxito con información mínima (id y nombre si disponible)
        String customerInfo = "id=" + latestCustomer.getId();
        if (latestCustomer.getFirstName() != null) {
            customerInfo += ", name=" + latestCustomer.getFirstName();
        }
        logger.info("GET /api/customer/latest - success - {}", customerInfo);

        result.put("message", "Latest customer retrieved successfully");
        result.put("success", true);
        result.put("data", latestCustomer);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

}
