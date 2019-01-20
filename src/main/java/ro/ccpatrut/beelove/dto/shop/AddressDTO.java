package ro.ccpatrut.beelove.dto.shop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class AddressDTO {

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String phoneNumber;

    @NotNull
    @Size(min = 5, max = 7)
    private String postalCode;


    @NotNull
    @Size(max = 255)
    @NotEmpty
    private String fullAddress;
}
