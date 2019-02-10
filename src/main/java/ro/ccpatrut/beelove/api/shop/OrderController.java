package ro.ccpatrut.beelove.api.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ccpatrut.beelove.dto.shop.OrderDTO;
import ro.ccpatrut.beelove.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return new ResponseEntity<>(this.orderService.getOrders(), HttpStatus.OK);
    }
}
