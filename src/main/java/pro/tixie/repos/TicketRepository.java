package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    public List<Ticket> findAll();
//    public List<Ticket> findAllByAuthorId(long authorId);
//    public List<Ticket> findAllByOwnerId(long ownerId);
//    public List<Ticket> findAllByPriorityId(long priorityId);
//    public List<Ticket> findAllBySpecializationId(long specializationId);
//    public List<Ticket> findAllByStatusId(long statusId);

}
