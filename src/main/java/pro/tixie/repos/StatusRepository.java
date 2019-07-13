package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
}
