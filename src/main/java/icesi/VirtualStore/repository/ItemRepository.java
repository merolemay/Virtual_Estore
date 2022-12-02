package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.Item;
import icesi.VirtualStore.model.OrderItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
    List<Item> findByAvailableAndItemType_ItemTypeId(boolean available, UUID itemTypeId);

    @Transactional
    @Modifying
    @Query("update Item i set i.available = ?1 where i.itemId = ?2")
    void updateAvailableByItemId(boolean available, UUID itemId);

    @Transactional
    @Modifying
    @Query("update Item i set i.orderItem = ?1 where i.itemId = ?2")
    void updateOrderItemByItemId(OrderItem orderItem, UUID itemId);

}
