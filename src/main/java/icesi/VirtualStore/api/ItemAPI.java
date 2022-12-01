package icesi.VirtualStore.api;


import icesi.VirtualStore.dto.ItemDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/items")
public interface ItemAPI {
    @GetMapping
    ItemDTO getItem(String id);

    @PostMapping
    List<ItemDTO> addItemStock(ItemDTO itemDTO, int quantity);

    @GetMapping("/all")
    List<ItemDTO> getAllItems();

    @PutMapping
    void updateItem(ItemDTO itemDTO, String name);

}
