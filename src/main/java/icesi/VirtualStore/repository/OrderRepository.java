package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {
    @Transactional
    @Modifying
    @Query("update Order o set o.status = ?1 where o.orderId = ?2")
    int updateStatusByOrderId(String status, UUID orderId);




}
