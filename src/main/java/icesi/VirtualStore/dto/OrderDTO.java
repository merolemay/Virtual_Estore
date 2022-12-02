package icesi.VirtualStore.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {

    private UUID orderId;

    private Double total;

    private String status;

    private List<OrderItemDTO> orderItems;
}
