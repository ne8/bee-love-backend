package ro.ccpatrut.beelove.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostDTO {
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;
}
