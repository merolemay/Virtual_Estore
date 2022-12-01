package icesi.VirtualStore.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderItemDTO {

    private String orderId;

    private int quantity;

    private List<ItemDTO> items;

}
