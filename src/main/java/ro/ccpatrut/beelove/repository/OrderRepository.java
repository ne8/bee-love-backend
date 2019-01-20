package ro.ccpatrut.beelove.repository;

import org.springframework.data.repository.CrudRepository;
import ro.ccpatrut.beelove.entities.shop.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
