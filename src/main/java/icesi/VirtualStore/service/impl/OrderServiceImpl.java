package icesi.VirtualStore.service.impl;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.model.Order;
import icesi.VirtualStore.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(String userId, String itemId, int quantity) {
        return null;
    }

    @Override
    public Order updateOrder(String userId, String itemId, int quantity, OrderStatus status) {
        return null;
    }

    @Override
    public Order deleteOrder(String userId, String orderId) {
        return null;
    }
}
