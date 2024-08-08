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
        // Publish an event to Kafka
//        String eventMessage = String.format("Order ID: %s, Product ID: %s, Quantity: %d",
//                createdOrder.getId(), createdOrder.getProductId(), createdOrder.getQuantity());
//        kafkaTemplate.send(TOPIC, eventMessage);
//
       return createdOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
