package icesi.VirtualStore.service;

import icesi.VirtualStore.dto.ItemDTO;
import icesi.VirtualStore.model.Item;

import java.util.List;

public interface ItemService {

        public Item getItem(String id);

        public List<Item> getAllItems();

        public Item updateItem(Item itemDTO, String name);

        public Item createItem(Item itemDTO);
}
