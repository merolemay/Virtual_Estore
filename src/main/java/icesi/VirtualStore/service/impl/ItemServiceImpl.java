package icesi.VirtualStore.service.impl;

import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import icesi.VirtualStore.error.exception.VirtualStoreError;
import icesi.VirtualStore.error.exception.VirtualStoreException;
import icesi.VirtualStore.model.Item;
import icesi.VirtualStore.model.ItemType;
import icesi.VirtualStore.repository.ItemRepository;
import icesi.VirtualStore.repository.ItemTypeRepository;
import icesi.VirtualStore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemTypeRepository itemTypeRepository;

    @Override
    public ItemType getItem(UUID id) {
        return itemTypeRepository.findById(id).orElseThrow(()-> new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_I_01, VirtualStoreErrorCode.CODE_I_01.getMessage())));
    }

    @Override
    public List<ItemType> getAllItemTypes() {
        return StreamSupport.stream(itemTypeRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public boolean updateItem(ItemType itemType, UUID id) {
        int result = itemTypeRepository.updateNameAndDescriptionAndPriceAndImageByItemTypeId(itemType.getName(), itemType.getDescription(), itemType.getPrice(), itemType.getImage(), id);
        if (result == 0) {
            throw new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_I_01, VirtualStoreErrorCode.CODE_I_01.getMessage()));
        }
        return true;
    }

    @Override
    public ItemType createItem(ItemType itemDTO) {
        return itemTypeRepository.save(itemDTO);
    }

    @Override
    public List<Item> addItemToStock(UUID itemTypeId, int quantity) {

        ItemType itemType = itemTypeRepository.findById(itemTypeId).orElseThrow(() -> new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_I_01, VirtualStoreErrorCode.CODE_I_01.getMessage())));

        for (int i = 0; i < quantity; i++) {
            Item item = Item.builder().itemId(UUID.randomUUID()).available(true).itemType(itemType).build();
            itemRepository.save(item);
        }

        return StreamSupport.stream(itemRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
