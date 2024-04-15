package org.example.dddstart.order.domain;

import jakarta.persistence.*;

@Embeddable
public class ShippingInfo {
    @Column(name = "shipping_message")
    private String message;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
    })
    private final Address address;

    @Embedded
    private final Receiver receiver;

    public ShippingInfo(Address address, Receiver receiver, String message) {
        this.address = address;
        this.receiver = receiver;
        this.message = message;
    }
}
