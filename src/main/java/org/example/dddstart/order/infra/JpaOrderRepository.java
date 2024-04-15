package org.example.dddstart.order.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.dddstart.order.domain.Order;
import org.example.dddstart.order.domain.OrderNo;
import org.example.dddstart.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findById(OrderNo id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> findByOrdererId(String ordererId, int startRow, int fetchSize) {
        TypedQuery<Order> query = entityManager.createQuery(
                "select o from Order o " +
                "where o.orderer.memberId = :ordererId " +
                "order by o.number.number desc",
                Order.class
        );

        query.setParameter("ordererId", ordererId);
        query.setFirstResult(startRow);
        query.setMaxResults(fetchSize);

        return query.getResultList();
    }

    /*
    실제로는 삭제 요구사항이 있더라도 데이터를 바로 삭제하지 않는 경우가 많다.
    정책적으로 관리자 기능에서 삭제한 데이터까지 조회해야 하는 경우도 있고 데이터 원복을 위해 일정 기간 보관해야 할 때도 있다.
    이런 이유로 사용자가 삭제 기능을 수행할 때 데이터를 바로 삭제하기보다는 삭제 플래그를 통해 데이터를 화면에 보여줄지 여부를 결정하는 방식을로 구현한다.
     */
    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }
}
