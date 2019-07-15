package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Status;

import java.util.List;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
    public List<Status> findAllById(long id);
    public Status findById(long id);
}
