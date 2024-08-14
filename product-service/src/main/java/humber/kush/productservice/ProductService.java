package humber.kush.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

//    public void consumeOrderPlacedEvent(OrderPlacedEvent event) {
//        ProductDTO product = getProductById(event.getProductIds()).get();
//        product.setStock(product.getStock()-event.getQuantities());
//        productRepository.save(productMapper.toEntity(product));
//    }
    public ProductDTO createProduct(ProductDTO product) {
        Product newProduct = productMapper.toEntity(product);
        Product savedProduct = productRepository.save(newProduct);
        return productMapper.toDTO(savedProduct);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productMapper.toDTOList(productList);
    }

    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public ProductDTO updateProduct(Long id, ProductDTO product) {
        Product newProduct = productMapper.toEntity(product);
        newProduct.setId(id);
        Product updatedProduct = productRepository.save(newProduct);
        return productMapper.toDTO(updatedProduct);
    }
}