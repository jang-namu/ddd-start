package org.example.dddstart.order.application;

import org.example.dddstart.order.domain.Order;
import org.example.dddstart.order.domain.OrderNo;
import org.example.dddstart.order.domain.OrderRepository;
import org.example.dddstart.order.domain.ShippingInfo;
import org.springframework.transaction.annotation.Transactional;

public class ChangeOrderService {

    private final OrderRepository orderRepository;

    public ChangeOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void changeShippingInfo(OrderNo no, ShippingInfo newShippingInfo) {
        Order order = orderRepository.findById(no);
        if (order == null) throw new OrderNotFoundException();
        order.changeShippingInfo(newShippingInfo);
    }
}
