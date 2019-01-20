package ro.ccpatrut.beelove.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ccpatrut.beelove.dto.BannerDTO;
import ro.ccpatrut.beelove.service.BannerService;

@RestController
@RequestMapping(value = "/banner", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<BannerDTO> getBanner() {
        return new ResponseEntity<>(this.bannerService.findFirstEntry(), HttpStatus.OK);
    }
}
