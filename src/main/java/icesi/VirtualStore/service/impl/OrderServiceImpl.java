package icesi.VirtualStore.service.impl;


import icesi.VirtualStore.model.Order;
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



    @Override
    public Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public Order createOrder(Order orderDTO) {
        userRepository.findById(orderDTO.getUser().getUserId()).orElseThrow().getOrderList().add(orderDTO);
        return orderRepository.save(orderDTO);
    }

    @Override
    public void updateOrder(Order order, String status) {
        orderRepository.updateStatusByOrderId(status,order.getOrderId());
         orderRepository.findById(order.getOrderId()).orElseThrow();
    }

    @Override
    public void deleteOrder(UUID orderId) {
         orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public List<Order> getUserOrders(UUID userId) {
        return userRepository.findById(userId).get().getOrderList();
    }
}
