package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.Order;
import icesi.VirtualStore.model.OrderItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
    @Transactional
    @Modifying
    @Query("update OrderItem o set o.order = ?1 where o.orderItemId = ?2")
    void updateOrderByOrderItemId(Order order, UUID orderItemId);

}
