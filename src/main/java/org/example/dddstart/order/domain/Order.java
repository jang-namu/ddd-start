package org.example.dddstart.order.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Order {
    private final OrderNo number;
    @Embedded
    private final Orderer orderer;
    @Embedded
    private final ShippingInfo shippingInfo;

    public Order(OrderNo number, Orderer orderer, ShippingInfo shippingInfo) {
        this.number = number;
        this.orderer = orderer;
        this.shippingInfo = shippingInfo;
    }
}
