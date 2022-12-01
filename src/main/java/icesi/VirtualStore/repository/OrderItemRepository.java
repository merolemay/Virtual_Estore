package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {

}
