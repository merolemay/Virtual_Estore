package icesi.VirtualStore.api;


import icesi.VirtualStore.dto.ItemTypeDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/items")
public interface ItemAPI {

    @GetMapping
    List<ItemTypeDTO> getAllItemTypes();

    @PostMapping()
    ItemTypeDTO addItemType(@RequestBody ItemTypeDTO itemTypeDTO);

    @GetMapping("/{id}")
    ItemTypeDTO getItem(@PathVariable UUID id);

    @PutMapping("/{id}")
    boolean updateItem(@RequestBody ItemTypeDTO itemTypeDTO, @PathVariable UUID id);

    @PostMapping("/{itemId}/stock")
    boolean addItemToStock(@PathVariable UUID itemId, @RequestBody int quantity);

}
