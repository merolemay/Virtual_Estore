package icesi.VirtualStore.mapper;

import icesi.VirtualStore.dto.OrderDTO;
import icesi.VirtualStore.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order fromDTO(OrderDTO orderDTO);
    OrderDTO fromOrder(Order order);
}
