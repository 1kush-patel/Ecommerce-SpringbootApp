package humber.kush.productservice;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDTO productDTO);
    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTOList(List<Product> products);
    ProductDTO toDTOOptional(Optional<Product> product);
}
