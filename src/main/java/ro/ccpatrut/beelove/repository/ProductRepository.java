package ro.ccpatrut.beelove.repository;

import org.springframework.data.repository.CrudRepository;
import ro.ccpatrut.beelove.entities.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity,Long> {
}
