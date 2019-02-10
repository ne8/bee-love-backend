package ro.ccpatrut.beelove.service;

import ro.ccpatrut.beelove.dto.shop.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrders();
}
