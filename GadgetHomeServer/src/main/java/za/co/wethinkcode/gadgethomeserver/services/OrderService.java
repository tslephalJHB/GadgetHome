package za.co.wethinkcode.gadgethomeserver.services;

import za.co.wethinkcode.gadgethomeserver.models.Order;
import za.co.wethinkcode.gadgethomeserver.repository.OrderRepository;

public class OrderService {

    private OrderRepository orderRepo;

    public OrderService() {
    }

    public void addOrder(Order order) {
        orderRepo.save(order);
    }

    public void orderRecieved(Order order) {
        order.setTransit("Delivered");
        order.setPaymentReleased(true);
        orderRepo.deleteById(order.getId());
        orderRepo.save(order);
    }

    public String trackOrder(String id) {
        Order order = orderRepo.getById(Long.valueOf(id));
        return order.getTransit();
    }
}
