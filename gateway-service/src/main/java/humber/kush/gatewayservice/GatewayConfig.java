package humber.kush.gatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class GatewayConfig {
    Logger logger = LoggerFactory.getLogger(GatewayConfig.class);

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // redirecting all admin related request to the core service
                .route("admin", r -> r.path("/api/admin/**")
                        .filters(f -> f.rewritePath("/api/(?<service>.*)/(?<remaining>.*)",
                                        "/${service}/${remaining}")
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://ADMIN-SERVICE"))

                // redirecting fetching all the products request to the core product service
                .route("all-products", r -> r.path("/api/all-products")
                        .filters(f -> f.rewritePath("/api/all-(?<service>.*)",
                                        "/${service}")
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://PRODUCT-SERVICE"))

                // redirecting fetching all the orders request to the core order service
                .route("all-orders", r -> r.path("/api/all-orders")
                        .filters(f -> f.rewritePath("/api/all-(?<service>.*)",
                                        "/${service}")
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://ORDER-SERVICE"))

                // redirecting create product request to the core product service
                .route("create-products", r -> r.path("/api/create-products")
                        .filters(f -> f.rewritePath("/api/create-(?<service>.*)",
                                        "/${service}/create")
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://PRODUCT-SERVICE"))

                // redirecting create order request to the core orders service
                .route("create-orders", r -> r.path("/api/create-orders")
                        .filters(f -> f.rewritePath("/api/create-(?<service>.*)",
                                        "/${service}/create")
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://ORDER-SERVICE"))

                // redirecting all remaining prducts related request to the core product service
                .route("product", r -> r.path("/api/products/**")
                        .filters(f -> f.rewritePath("/api/(?<service>.*)/(?<remaining>.*)",
                                        "/${service}/${remaining}")
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://PRODUCT-SERVICE"))

                // redirecting all remaining order related request to the core order service
                    .route("order", r -> r.path("/api/orders/**")
                        .filters(f -> f.rewritePath("/api/(?<service>.*)/(?<remaining>.*)",
                                        "/${service}/${remaining}")
                                .circuitBreaker(config -> config.setName("userCircuitBreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://ORDER-SERVICE"))
                .build();
    }
}