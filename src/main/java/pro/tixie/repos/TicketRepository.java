package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Ticket;
import pro.tixie.model.User;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    public List<Ticket> findAll();
    public List<Ticket> findAllByAuthor(long authorId);
    public List<Ticket> findAllByOwner(long ownerId);
    public List<Ticket> findAllByPriority(long priorityId);
    public List<Ticket> findAllBySpecialization(long specializationId);
    public List<Ticket> findAllByStatus(long statusId);

}
