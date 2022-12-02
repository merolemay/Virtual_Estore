package icesi.VirtualStore.api;


import icesi.VirtualStore.dto.ItemTypeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/items")
public interface ItemAPI {

    @GetMapping
    List<ItemTypeDTO> getAllItemTypes();

    @PostMapping
    ItemTypeDTO addItemType(ItemTypeDTO itemTypeDTO);

    @GetMapping("/{itemId}")
    ItemTypeDTO getItem(@PathVariable UUID itemId);

    @PutMapping
    boolean updateItem(ItemTypeDTO itemTypeDTO, UUID name);

    @PostMapping("/{itemId}/stock")
    boolean addItemToStock(@PathVariable UUID itemId, int quantity);

}
