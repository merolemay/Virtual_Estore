package icesi.VirtualStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private UUID orderId;

    private Double total;

    private String status;

    private List<OrderItemDTO> orderItems;

    private UUID userId;
}
