package humber.kush.orderservice;

import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

public class PublisherKafkaFunctions {
    @Bean
    public Consumer<Boolean> productQuantityUpdateResponse(){
        return (Boolean success)->{
            if(success) {
                System.out.println("Product Quantity updated Successfully");
            }
        };
    }

}
