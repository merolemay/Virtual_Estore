package icesi.VirtualStore.service;

import icesi.VirtualStore.model.Item;
import icesi.VirtualStore.model.ItemType;

import java.util.List;

public interface ItemService {

    Item getItem(String id);

    List<Item> getAllItems();

    ItemType updateItem(ItemType itemType, String name);

    Item createItem(Item itemDTO);
}
