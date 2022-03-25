package za.co.wethinkcode.gadgethomeserver.controller;

import org.springframework.web.bind.annotation.*;
import za.co.wethinkcode.gadgethomeserver.models.Order;
import za.co.wethinkcode.gadgethomeserver.services.OrderService;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService = new OrderService();

    @GetMapping("/{id}")
    public String trackOrder(@PathVariable String id) {
        return orderService.trackOrder(id);
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody Map<String, String> map){

    }
}
