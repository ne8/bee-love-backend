package ro.ccpatrut.beelove.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ccpatrut.beelove.dto.SliderDTO;
import ro.ccpatrut.beelove.service.SliderService;

import java.util.List;

@RestController
@RequestMapping(value = "/slider", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

public class SliderController {

    @Autowired
    private SliderService sliderService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SliderDTO>> getProducts() {
        return new ResponseEntity<>(this.sliderService.findAll(), HttpStatus.OK);
    }
}
