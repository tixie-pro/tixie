package pro.tixie.controllers.user;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.tixie.model.*;
import pro.tixie.repos.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    private UserRepository userDao;
    private TicketRepository ticketDao;
    private StatusRepository statusDao;
    private PriorityRepository priorDao;
    private SpecializationRepo specDao;
    private NoteRepository noteDao;
    public EmployeeController(UserRepository userDao,
                              TicketRepository ticketDao,
                              StatusRepository statusDao,
                              PriorityRepository priorDao,
                              SpecializationRepo specDao,
                              NoteRepository noteDao) {
        this.userDao = userDao;
        this.ticketDao = ticketDao;
        this.statusDao = statusDao;
        this.priorDao = priorDao;
        this.specDao = specDao;
        this.noteDao = noteDao;
    }

    @GetMapping("/employee/{id}")
    public String allTixByEmployee(@PathVariable long id, Model model) {
        User userTix = userDao.findOne(id);
        Ticket tixNote = ticketDao.findOne(id);
        List<Note> note = noteDao.findAllByTicket(tixNote);
        model.addAttribute("tix", ticketDao.findAllByAuthor(userTix));
        model.addAttribute("employee", userDao);
        model.addAttribute("note", note);
        return "user/employee/index";
    }

    @GetMapping("/employee/ticket/create")
    public String showTicketCreate(Model model, Status status, Specialization spec, Priority prior, Note note) {
        model.addAttribute("tix", new Ticket());
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("status", status);
        model.addAttribute("spec", spec);
        model.addAttribute("priority", prior);
        model.addAttribute("note", note);
        return "user/employee/create_ticket";
    }

    @PostMapping("/employee/ticket/create")
    public String employeeTicketCreate(Model model, Ticket ticketCreated) {
        System.out.println(ticketCreated);
        ticketDao.save(ticketCreated);
    return "redirect:/";
    }
}
