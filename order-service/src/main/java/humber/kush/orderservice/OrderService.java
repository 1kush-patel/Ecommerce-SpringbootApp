package humber.kush.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
//    @Autowired
//    private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        order.setOrderDate(LocalDateTime.now()); // Set current date and time
        Order savedOrder = orderRepository.save(order);
//        OrderPlacedEvent event = new OrderPlacedEvent(order.getId(), order.getProductId(), order.getQuantity());
//        kafkaTemplate.send("order-placed", event);
        return orderMapper.toDTO(savedOrder);
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<OrderDTO> getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(orderMapper::toDTO);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        orderDTO.setId(id);
        OrderDTO updatedOrder = orderMapper.toDTO(orderRepository.save(orderMapper.toEntity(orderDTO)));
        return updatedOrder;
    }
}
