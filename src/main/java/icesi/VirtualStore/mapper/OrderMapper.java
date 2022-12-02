package icesi.VirtualStore.mapper;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.dto.OrderDTO;
import icesi.VirtualStore.dto.OrderItemDTO;
import icesi.VirtualStore.model.Order;
import icesi.VirtualStore.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "orderItemList", target = "orderItems")
    OrderDTO fromOrder(Order order);

    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "orderItems", target = "orderItemList")
    Order fromDTO(OrderDTO orderDTO);

    @Mapping(target = "orderItemId", source = "orderItemId")
    @Mapping(target = "quantity", source = "quantity")
    OrderItem fromDTO(OrderItemDTO orderItemDTO);

    @Mapping(target = "orderItemId", source = "orderItemId")
    @Mapping(target = "quantity", source = "quantity")
    default OrderItemDTO fromOrderItem(OrderItem orderItem){
        return OrderItemDTO.builder()
                .orderItemId(orderItem.getOrderItemId())
                .quantity(orderItem.getQuantity())
                .itemId(orderItem.getItems().stream().findFirst().orElseThrow().getItemType().getItemTypeId())
                .build();
    }

    default String fromOrderStatus(OrderStatus status) {
        return status.getMessage();
    }

    default OrderStatus toOrderStatus(String status) {
        return OrderStatus.valueOf(status);
    }
}
