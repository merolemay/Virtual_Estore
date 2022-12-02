package icesi.VirtualStore.controller;

import icesi.VirtualStore.api.ItemAPI;
import icesi.VirtualStore.dto.ItemTypeDTO;
import icesi.VirtualStore.mapper.ItemTypeMapper;
import icesi.VirtualStore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ItemController implements ItemAPI {

    private ItemService itemService;
    private ItemTypeMapper itemTypeMapper;

    @Override
    public ItemTypeDTO getItem(UUID id) {
        return itemTypeMapper.fromItem(itemService.getItem(id));
    }

    @Override
    public ItemTypeDTO addItemType(ItemTypeDTO itemTypeDTO) {
        return itemTypeMapper.fromItem(itemService.createItem(itemTypeMapper.fromDTO(itemTypeDTO)));
    }

    @Override
    public boolean addItemToStock(UUID itemTypeId, int quantity) {
        boolean isEmpty = itemService.addItemToStock(itemTypeId, quantity).isEmpty();
        return !isEmpty;
    }

    @Override
    public List<ItemTypeDTO> getAllItemTypes() {
        return itemService.getAllItemTypes().stream().map(itemTypeMapper::fromItem).collect(Collectors.toList());
    }

    @Override
    public boolean updateItem(ItemTypeDTO itemTypeDTO, UUID itemTypeId) {
        return itemService.updateItem(itemTypeMapper.fromDTO(itemTypeDTO),itemTypeId);
    }
}
