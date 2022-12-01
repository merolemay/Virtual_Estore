package icesi.VirtualStore.service;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.model.Order;

public interface OrderService {

        public Order createOrder(String userId, String itemId, int quantity);

        public Order updateOrder(String userId, String itemId, int quantity, OrderStatus status);

        public Order deleteOrder(String userId, String orderId);

}
