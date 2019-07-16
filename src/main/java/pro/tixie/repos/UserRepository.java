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
<<<<<<< HEAD
    public List<User> findAll();
    public List<User> findAllByRole( Role role);
    public List<User> findAllBySpecialization(Specialization spec);


=======
>>>>>>> 4430cc8ea568e65c8ece0e8fed15faa688fc9f70
}
