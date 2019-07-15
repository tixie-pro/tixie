package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
