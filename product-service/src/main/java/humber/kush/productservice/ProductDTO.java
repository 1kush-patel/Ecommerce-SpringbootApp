package humber.kush.productservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private double price;
    private int stock;
    private String imageId;
}