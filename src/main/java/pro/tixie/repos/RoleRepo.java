package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Role;
import pro.tixie.model.Specialization;

import java.util.List;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long>{
    public List<Role> findAll();
    public List<Role> findAllById(long id);
    public Role findById(long id);

}
