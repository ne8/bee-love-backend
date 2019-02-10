package ro.ccpatrut.beelove.api.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ccpatrut.beelove.dto.shop.OrderDTO;
import ro.ccpatrut.beelove.service.CheckoutService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/checkout", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> doCheckout(@Valid @RequestBody final OrderDTO orderDTO) {
        log.debug(orderDTO.toString());
        this.checkoutService.doCheckout(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
