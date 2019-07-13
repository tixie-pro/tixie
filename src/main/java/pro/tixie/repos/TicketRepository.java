package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Priority;
import pro.tixie.model.Status;
import pro.tixie.model.Ticket;
import pro.tixie.model.User;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    public List<Ticket> findAll();
    public List<Ticket> findAllByAuthor(User user);
    public List<Ticket> findAllByOwner(User user);
    public List<Ticket> findAllByPriority(Priority priority);
    public List<Ticket> findAllBySpecialization(long specializationId);
    public List<Ticket> findAllByStatus(Status status);

}
