package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Specialization;

@Repository
public interface SpecializationRepo extends CrudRepository<Specialization, Long>{

}
