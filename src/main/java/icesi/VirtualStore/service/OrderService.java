package icesi.VirtualStore.service;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.model.Order;

import java.util.UUID;

public interface OrderService {

        public Order createOrder(UUID userId, UUID itemId, int quantity);

        public Order updateOrder(UUID orderId, String status);

        public void deleteOrder(UUID orderId);


}
