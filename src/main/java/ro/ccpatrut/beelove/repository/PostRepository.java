package ro.ccpatrut.beelove.repository;

import org.springframework.data.repository.CrudRepository;
import ro.ccpatrut.beelove.entities.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity,Long> {
}
