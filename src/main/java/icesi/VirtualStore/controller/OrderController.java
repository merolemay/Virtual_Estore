package icesi.VirtualStore.controller;

import icesi.VirtualStore.api.OrderAPI;
import icesi.VirtualStore.dto.OrderDTO;
import icesi.VirtualStore.mapper.OrderMapper;
import icesi.VirtualStore.model.Order;
import icesi.VirtualStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class OrderController implements OrderAPI {

    public final OrderService orderService;

    public  final OrderMapper orderMapper;


    @Override
    public OrderDTO getOrder(@NotNull UUID id) {
        return orderMapper.fromOrder(orderService.getOrder(id));
    }

    @Override
    public List<OrderDTO> getUserOrders(@NotNull UUID userId) {
        return orderService.getUserOrders(userId).stream().map(orderMapper::fromOrder).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderService.getOrders().stream().map(orderMapper::fromOrder).collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return orderMapper.fromOrder(orderService.createOrder(orderMapper.fromDTO(orderDTO)));
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO,String status) {
        return orderMapper.fromOrder(orderService.updateOrder(orderMapper.fromDTO(orderDTO),status));
    }
}
