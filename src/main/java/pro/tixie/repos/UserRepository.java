package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Role;
import pro.tixie.model.Specialization;
import pro.tixie.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    public List<User> findAll();
    public List<User> findAllByRole( Role role);
    public List<User> findAllBySpecialization(Specialization spec);

}
