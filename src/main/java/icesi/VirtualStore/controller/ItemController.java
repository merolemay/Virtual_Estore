package icesi.VirtualStore.controller;

import icesi.VirtualStore.api.ItemAPI;
import icesi.VirtualStore.dto.ItemDTO;

import java.util.List;

public class ItemController implements ItemAPI {

    @Override
    public ItemDTO getItem(String id) {
        return null;
    }

    @Override
    public List<ItemDTO> addItemStock(ItemDTO itemDTO, int quantity) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return null;
    }

    @Override
    public void updateItem(ItemDTO itemDTO, String name) {

    }
}
