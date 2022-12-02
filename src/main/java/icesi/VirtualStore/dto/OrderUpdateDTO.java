package icesi.VirtualStore.dto;

import icesi.VirtualStore.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdateDTO {

    private UUID orderId;

    private OrderStatus status;
}
