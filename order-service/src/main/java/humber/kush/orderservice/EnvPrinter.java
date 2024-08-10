package humber.kush.orderservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvPrinter {
    @Autowired
    private Environment env;

    @PostConstruct
    public void logApplicationProperties(){
        System.out.println("Env"+env.getProperty("spring.datasource.url"));
    }
}
