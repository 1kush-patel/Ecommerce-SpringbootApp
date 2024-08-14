package humber.kush.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class SubscribeKafkaFunctions {

    private final Logger logger =
            LoggerFactory.getLogger(SubscribeKafkaFunctions.class);

    @Bean
    Function<OrderPlacedEvent, Boolean> orderCreated(){
        return (OrderPlacedEvent orderEvent)->{
            logger.info("Oder info " + orderEvent.getOrderId() + orderEvent.getQuantities());
            return true;
        };
    }

}
