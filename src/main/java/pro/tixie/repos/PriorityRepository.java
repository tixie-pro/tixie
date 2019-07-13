package pro.tixie.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Priority;

@Repository
public interface PriorityRepository extends CrudRepository<Priority, Long> {
}
