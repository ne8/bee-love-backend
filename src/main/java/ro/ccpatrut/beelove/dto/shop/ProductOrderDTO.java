package ro.ccpatrut.beelove.dto.shop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
public class ProductOrderDTO {

    @NotNull
    @Min(0)
    private Long id;

    @NotNull
    @Size(min = 5)
    private String name;

    @Min(0)
    private Long quantity;

}
