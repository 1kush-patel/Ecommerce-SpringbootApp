package humber.kush.orderservice;

import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO dto);
}
