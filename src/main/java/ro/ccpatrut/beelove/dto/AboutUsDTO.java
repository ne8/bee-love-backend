package ro.ccpatrut.beelove.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AboutUsDTO {

    private Long id;

    private String imgLocation;

    private String alt;

    private String subtitle;

    private String text;
}
