package com.app.mobilpymes.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String status;
    private String firstName;
    private String lastName;
    private String email;
    private String documentId;
    private String phoneNumber;
    private String imageCustomer;
}
