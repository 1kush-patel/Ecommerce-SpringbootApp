package humber.kush.orderservice.service;

import humber.kush.orderservice.model.Order;
import humber.kush.orderservice.repository.OrderRepository;
import jakarta.validation.OverridesAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;



    private static final String TOPIC = "orderPlaced";

    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        Order createdOrder = orderRepository.save(order);
      
       return createdOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Order order) {
        if (order.getId() == null || !orderRepository.existsById(order.getId())) {
            throw new IllegalArgumentException("Order with given ID does not exist.");
        }
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Order with given ID does not exist.");
        }
        orderRepository.deleteById(id);
    }
}
