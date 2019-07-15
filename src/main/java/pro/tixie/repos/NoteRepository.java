package pro.tixie.repos;

import org.springframework.data.repository.CrudRepository;
import pro.tixie.model.Note;
import pro.tixie.model.Ticket;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {
    public List<Note> findAllByTicket(Ticket tix);
}
