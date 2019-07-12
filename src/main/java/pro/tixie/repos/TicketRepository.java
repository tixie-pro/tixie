package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.tixie.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
