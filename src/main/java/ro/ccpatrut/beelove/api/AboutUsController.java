package ro.ccpatrut.beelove.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ccpatrut.beelove.dto.AboutUsDTO;
import ro.ccpatrut.beelove.service.AboutUsService;

import java.util.List;

@RestController
@RequestMapping(value = "/about", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AboutUsController {

    @Autowired
    private AboutUsService aboutUsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AboutUsDTO>> getBanner() {
        return new ResponseEntity<>(this.aboutUsService.findAll(), HttpStatus.OK);
    }
}
