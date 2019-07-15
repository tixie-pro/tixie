package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Specialization;

import java.util.List;

@Repository
public interface SpecializationRepo extends CrudRepository<Specialization, Long>{

    List<Specialization> findAllById(long id);
    Specialization findById(long id);

}
