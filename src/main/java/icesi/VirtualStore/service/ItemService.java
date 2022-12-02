package icesi.VirtualStore.service;

import icesi.VirtualStore.model.Item;
import icesi.VirtualStore.model.ItemType;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    ItemType getItem(UUID id);

    List<ItemType> getAllItemTypes();

    boolean updateItem(ItemType itemType, UUID id);

    ItemType createItem(ItemType itemDTO);

    List<Item> addItemToStock(UUID itemTypeId, int quantity);

}
