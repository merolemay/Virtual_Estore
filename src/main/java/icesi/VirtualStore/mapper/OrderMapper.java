package icesi.VirtualStore.mapper;

import icesi.VirtualStore.dto.OrderDTO;
import icesi.VirtualStore.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

        @Mapping(source = "orderId", target = "orderId")
        @Mapping(source = "status", target = "status")
        @Mapping(source = "total", target = "total")
        @Mapping(source = "orderItemList", target = "orderItems")
        OrderDTO fromItem(Order order);

        @Mapping(source = "orderId", target = "orderId")
        @Mapping(source = "status", target = "status")
        @Mapping(source = "total", target = "total")
        @Mapping(source = "orderItems", target = "orderItemList")
        Order fromDTO(OrderDTO orderDTO);

}
