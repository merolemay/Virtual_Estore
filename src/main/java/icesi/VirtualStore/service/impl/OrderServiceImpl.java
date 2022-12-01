package icesi.VirtualStore.service.impl;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.model.Order;
import icesi.VirtualStore.repository.OrderRepository;
import icesi.VirtualStore.repository.UserRepository;
import icesi.VirtualStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    public final OrderRepository orderRepository;

    public final UserRepository userRepository;


    @Override
    public Order createOrder(UUID userId, UUID itemId, int quantity) {
        return orderRepository.save(new Order(UUID.randomUUID(),quantity,OrderStatus.STATUS_01.getMessage(),userRepository.findById(userId)
                .orElseThrow()));
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
}
