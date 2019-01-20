package ro.ccpatrut.beelove.repository;

import org.springframework.data.repository.CrudRepository;
import ro.ccpatrut.beelove.entities.BannerEntity;
import ro.ccpatrut.beelove.entities.PostEntity;

public interface BannerRepository  extends CrudRepository<BannerEntity, Long> {
}
