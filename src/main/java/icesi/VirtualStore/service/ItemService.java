package icesi.VirtualStore.service;

import icesi.VirtualStore.dto.ItemDTO;
import icesi.VirtualStore.model.Item;

import java.util.List;

public interface ItemService {

        public ItemDTO getItem(String id);

        public List<Item> getAllItems();

        public void updateItem(ItemDTO itemDTO, String name);

        public Item createItem(ItemDTO itemDTO);
}
