package ro.ccpatrut.beelove.service;

import ro.ccpatrut.beelove.dto.shop.OrderDTO;

public interface CheckoutService {
    void doCheckout(OrderDTO orderDTO);
}
