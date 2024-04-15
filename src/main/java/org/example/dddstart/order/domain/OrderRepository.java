package org.example.dddstart.order.domain;

import java.util.List;

/*
Repository는 애그리거트 '루트'를 기준으로 저장/삭제/업데이트한다.
Repository의 인터페이스는 Order와 같은 도메인 영역에 위치한다.
그리고 Repository의 구현체는 infra 영역에 위치시켜서 인프라스트럭처에 대한 의존도를 낮출 수 있다.
 */
public interface OrderRepository {
    public Order findById(OrderNo id);
    public void save(Order order);
    public List<Order> findByOrdererId(String ordererId, int startRow, int size);
    public void delete(Order order);
}
