package com.app.mobilpymes.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public
class PaymentItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String typeCard;
    @NotNull
    private String numberCard;
    @NotNull
    private String dateExpired;
    @NotNull
    private String cvv;
    @NotNull
    private String statusCard;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;
}
