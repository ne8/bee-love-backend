package ro.ccpatrut.beelove.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private String pathToImage;

    private String description;
}
