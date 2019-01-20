package ro.ccpatrut.beelove.dto.shop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderDTO {

    @Valid
    private AddressDTO address;

    @Valid
    private UserDTO userData;

    @Valid
    private List<ProductOrderDTO> products;

}
