package icesi.VirtualStore.service.impl;

import icesi.VirtualStore.model.Item;
import icesi.VirtualStore.model.ItemType;
import icesi.VirtualStore.repository.ItemRepository;
import icesi.VirtualStore.repository.ItemTypeRepository;
import icesi.VirtualStore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemTypeRepository itemTypeRepository;

    @Override
    public Item getItem(String id) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public ItemType updateItem(ItemType itemType, String name) {
        int result = itemTypeRepository.updateNameAndDescriptionAndPriceAndImageByItemTypeId(itemType.getName(), itemType.getDescription(), itemType.getPrice(), itemType.getImage(), itemType.getItemTypeId());
        if (result == 0) {
            throw new RuntimeException("Item type not found");
        }
        return itemTypeRepository.findByName(itemType.getName()).get();
    }

    @Override
    public Item createItem(Item itemDTO) {
        return null;
    }
}
