package humber.kush.adminservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String imageId;
}
