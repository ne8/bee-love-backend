package ro.ccpatrut.beelove.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SliderDTO {

    @NotNull
    private Long id;

    @NotNull
    private String imageLocation;

    @NotNull
    private String title;

    @NotNull
    private String alt;

    @NotNull
    private String description;
}
