package icesi.VirtualStore.controller;

import icesi.VirtualStore.api.OrderAPI;
import icesi.VirtualStore.dto.OrderDTO;

import java.util.List;

public class OrderController implements OrderAPI {
    @Override
    public OrderDTO getOrder(String id) {
        return null;
    }

    @Override
    public List<OrderDTO> getUserOrders(String userId) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {

    }
}
