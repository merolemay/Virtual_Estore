package icesi.VirtualStore.api;


import icesi.VirtualStore.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
public interface OrderAPI {
    @GetMapping
    OrderDTO getOrder(String id);

    @GetMapping("/all/{userId}")
    List<OrderDTO> getUserOrders(@PathVariable String userId);

    @GetMapping("/all")
    List<OrderDTO> getAllOrders();

    @PostMapping
    OrderDTO createOrder(@RequestBody OrderDTO orderDTO);

    @PutMapping
    void updateOrder(OrderDTO orderDTO);
}
