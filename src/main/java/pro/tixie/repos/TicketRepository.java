package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.*;
import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    public List<Ticket> findAll();
    public List<Ticket> findAllByAuthor(User user);
    public List<Ticket> findAllByOwner(User user);
    public List<Ticket> findAllByPriority(Priority priority);
    public List<Ticket> findAllBySpecialization(Specialization spec);
    public List<Ticket> findAllByStatus(Status status);
    public List<Ticket> findAllByBiohazardEquals(int id);



}
