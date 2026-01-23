package com.app.mobilpymes.shoppingcart.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String firstName;
    private String lastName;
    private String email;
    private String documentId;
    private String phoneNumber;
    private String imageCustomer;

    @Lob
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    public Customer() {}

    public Customer(Long id, String status, String firstName, String lastName,
                    String email, String documentId, String phoneNumber, String imageCustomer,
                    String comment) {
        this.id = id;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
        this.imageCustomer = imageCustomer;
        this.comment = comment;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDocumentId() { return documentId; }
    public void setDocumentId(String documentId) { this.documentId = documentId; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getImageCustomer() { return imageCustomer; }
    public void setImageCustomer(String imageCustomer) { this.imageCustomer = imageCustomer; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String status;
        private String firstName;
        private String lastName;
        private String email;
        private String documentId;
        private String phoneNumber;
        private String imageCustomer;
        private String comment;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder status(String status) { this.status = status; return this; }
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder documentId(String documentId) { this.documentId = documentId; return this; }
        public Builder phoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder imageCustomer(String imageCustomer) { this.imageCustomer = imageCustomer; return this; }
        public Builder comment(String comment) { this.comment = comment; return this; }

        public Customer build() {
            return new Customer(id, status, firstName, lastName, email, documentId, phoneNumber, imageCustomer, comment);
        }
    }
}
