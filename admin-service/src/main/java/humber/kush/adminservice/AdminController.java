package humber.kush.adminservice;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private RestTemplate restTemplate;


    //create product mapping
    @PostMapping("create-products")
    public RedirectView createProduct(@RequestHeader("User-Role") String userRole, @RequestBody ProductDTO productDTO){
        if(userRole.equals("admin")){
            return new RedirectView("http://localhost:8080/api/create-products");
            //return ok("Product created!");
        }
        return null;
       //return ResponseEntity.status(400).body("Invalid user role");
    }

    //update product by Id mapping
    @PutMapping("product/{id}")
    public RedirectView updateProduct(@RequestHeader("User-Role") String userRole, @PathVariable Long id, @RequestBody ProductDTO productDTO){
        if(userRole.equals("admin")){
            return new RedirectView("http://localhost:8080/api/products/" + id);
            //return ok("Product updated!");
        }
        return null;
        //return ResponseEntity.status(400).body("Invalid user role");
    }

    //delete product by id mapping
    @DeleteMapping("product/{id}")
    public RedirectView deleteProduct(@RequestHeader("User-Role") String userRole, @PathVariable Long id){
        if(userRole.equals("admin")){
            return new RedirectView("http://localhost:8080/api/products/" + id);
            //return ok("Product deleted!");
        }
        return null;
        //return ResponseEntity.status(400).body("Invalid user role");
    }

    //get product by id mapping
    @GetMapping("product/{id}")
    public RedirectView getProduct(@RequestHeader("User-Role") String userRole, @PathVariable Long id){
        if(userRole.equals("admin")){
//            restTemplate = new RestTemplate();
//            ProductDTO productDTO = restTemplate.getForObject("http://localhost:8080/api/products/" + id, ProductDTO.class);
//            return ResponseEntity.ok(productDTO);
            return new RedirectView("http://localhost:8080/api/products/" + id);
        }
        //return ResponseEntity.status(400).body("Invalid user role");
        return null;
    }

    //get all the available products
    @GetMapping("all-products")
    public RedirectView getAllProduct(@RequestHeader("User-Role") String userRole){
            if(userRole.equals("admin")){
//            restTemplate = new RestTemplate();
//            ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
//                    "http://localhost:8080/api/all-products",
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<ProductDTO>>() {}
//            );
//
//            System.out.println("-----productsresponse---"+response);
//            List<ProductDTO> products = response.getBody();
//            System.out.println("-----products---"+products);
//            return ResponseEntity.ok(products);
        return new RedirectView("http://localhost:8080/api/all-products");
        }
        //return ResponseEntity.status(400).body("Invalid user role");
    return null;
    }

    //create order mapping
    @PostMapping("create-orders")
    public RedirectView createOrder(@RequestHeader("User-Role") String userRole, @RequestBody OrderDTO orderDTO){
        if(userRole.equals("admin")){
            return new RedirectView("http://localhost:8080/api/create-orders");
            //return ResponseEntity.ok("Order created!");
        }
        return null;
        //return ResponseEntity.status(400).body("Invalid user role");
    }

    //get order info by id mapping
    @GetMapping("order/{id}")
    public RedirectView getOrder(@RequestHeader("User-Role") String userRole, @PathVariable Long id){
        if(userRole.equals("admin")){
//            restTemplate = new RestTemplate();
//            OrderDTO orderDTO = restTemplate.getForObject("http://localhost:8080/api/orders/" + id, OrderDTO.class);
//            return ResponseEntity.ok(orderDTO);
            return new RedirectView("http://localhost:8080/api/orders/" + id);
        }
        //return ResponseEntity.status(400).body("Invalid user role");
        return null;
    }

    //update order by id mapping
    @PutMapping("order/{id}")
    public RedirectView updateOrder(@RequestHeader("User-Role") String userRole, @PathVariable Long id, @RequestBody OrderDTO orderDTO){
        if(userRole.equals("admin")){
            return new RedirectView("http://localhost:8080/api/orders/" + id);
            //return ResponseEntity.ok("Order updated!");
        }
        return null;
        //return ResponseEntity.status(400).body("Invalid user role");
    }

    //delete order by id mapping
    @DeleteMapping("order/{id}")
    public RedirectView deleteOrder(@RequestHeader("User-Role") String userRole, @PathVariable Long id){
        if(userRole.equals("admin")){
            return new RedirectView("http://localhost:8080/api/orders/" + id);
            //return ResponseEntity.ok("Order deleted!");
        }
        return null;
        //return ResponseEntity.status(400).body("Invalid user role");
    }

    //get all the available orders mapping
    @GetMapping("all-orders")
    public RedirectView getAllOrder(@RequestHeader("User-Role") String userRole){
        if(userRole.equals("admin")){
//            restTemplate = new RestTemplate();
//            ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(
//                    "http://localhost:8080/api/all-orders",
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<OrderDTO>>() {}
//            );
//
//            List<OrderDTO> orders = response.getBody();
//            return ResponseEntity.ok(orders);
            return new RedirectView("http://localhost:8080/api/all-orders");
        }
        //return ResponseEntity.status(400).body("Invalid user role");
        return null;
    }
}
