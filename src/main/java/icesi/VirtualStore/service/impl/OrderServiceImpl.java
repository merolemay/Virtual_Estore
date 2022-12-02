package icesi.VirtualStore.service.impl;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.mapper.OrderMapper;
import icesi.VirtualStore.model.Order;
import icesi.VirtualStore.model.OrderItem;
import icesi.VirtualStore.repository.OrderItemRepository;
import icesi.VirtualStore.repository.OrderRepository;
import icesi.VirtualStore.repository.UserRepository;
import icesi.VirtualStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    public final OrderRepository orderRepository;

    public final UserRepository userRepository;

    public final OrderMapper orderMapper;


    @Override
    public Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public Order createOrder(Order orderDTO) {
        return orderRepository.save(orderDTO);
    }

    @Override
    public Order updateOrder(UUID orderId, String status) {
        orderRepository.updateStatusByOrderId(status, orderId);
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public void deleteOrder(UUID orderId) {
         orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
