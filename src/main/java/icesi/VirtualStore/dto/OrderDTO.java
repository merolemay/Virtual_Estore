package icesi.VirtualStore.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private String orderId;

    private Double total;

    private String status;

    private List<OrderItemDTO> orderItems;
}
