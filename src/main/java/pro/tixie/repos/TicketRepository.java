package pro.tixie.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    Page<Ticket> findAll(Pageable pageable);
    Page<Ticket> findAllByOwner(User user, Pageable pageable);
    Page<Ticket> findAllByOwnerAndStatus(User owner, Status status, Pageable pageable);
    List<Ticket> findAllByOwnerAndStatus(User owner, Status status);


}
