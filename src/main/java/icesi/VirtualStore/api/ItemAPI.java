package icesi.VirtualStore.api;


import icesi.VirtualStore.dto.ItemDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/items")
public interface ItemAPI {
    @GetMapping
    public ItemDTO getItem(String id);

    @GetMapping("/all")
    public List<ItemDTO> getAllItems();

    @PutMapping
    public void updateItem(ItemDTO itemDTO, String name);

}
