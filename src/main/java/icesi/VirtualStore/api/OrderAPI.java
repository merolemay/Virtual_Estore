package icesi.VirtualStore.api;


import icesi.VirtualStore.dto.OrderDTO;
import icesi.VirtualStore.dto.OrderUpdateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/orders")
public interface OrderAPI {
    @GetMapping("/{orderId}")
    OrderDTO getOrder(@PathVariable UUID orderId);

    @GetMapping("/all/{userId}")
    List<OrderDTO> getUserOrders(@PathVariable UUID userId);

    @GetMapping
    List<OrderDTO> getAllOrders();

    @PostMapping
    OrderDTO createOrder(@RequestBody OrderDTO orderDTO);

    @PutMapping
    void updateOrder(@RequestBody OrderUpdateDTO orderUpdateDTO);
}
