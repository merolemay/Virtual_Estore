package icesi.VirtualStore.service;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.model.Order;

public interface OrderService {

    Order createOrder(String userId, String itemId, int quantity);

    Order updateOrder(String userId, String itemId, int quantity, OrderStatus status);

    Order deleteOrder(String userId, String orderId);

}
