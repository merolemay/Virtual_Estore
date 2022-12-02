package icesi.VirtualStore.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderItemDTO {

    private UUID orderId;

    private int quantity;

    private UUID itemId;

}
