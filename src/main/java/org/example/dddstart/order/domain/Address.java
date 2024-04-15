package org.example.dddstart.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipCode;
    private String address1;
    private String address2;
}
