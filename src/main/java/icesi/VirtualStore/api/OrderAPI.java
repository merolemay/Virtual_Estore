package icesi.VirtualStore.api;


import icesi.VirtualStore.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
public interface OrderAPI {
    @GetMapping
    public OrderDTO getOrder(String id);

    @GetMapping("/all/{userId}")
    public List<OrderDTO> getUserOrders(@PathVariable String userId);

    @GetMapping("/all")
    public List<OrderDTO> getAllOrders();

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO);

    @PutMapping
    public void updateOrder(OrderDTO orderDTO);
}
