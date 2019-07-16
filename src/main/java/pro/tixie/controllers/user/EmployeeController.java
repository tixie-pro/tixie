package pro.tixie.controllers.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.tixie.model.*;
import pro.tixie.repos.*;

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
        model.addAttribute("tix", ticketDao.findAllByAuthor(userTix));
        model.addAttribute("employee", userDao);
        return "user/employee/index";
    }

    @RequestMapping("/employee/ticket/create")
    public String showTicketCreate(Model model) {
        model.addAttribute("tix", new Ticket());
        model.addAttribute("status", new Status());
        model.addAttribute("spec", new Specialization());
        model.addAttribute("priority", new Priority());
        model.addAttribute("notes", new Note());
        return "user/employee/index";
    }

    @PostMapping("/employee/ticket/create/{id}")
    public String employeeTicketCreate(Model model, Ticket ticketCreated) {
        ticketDao.save(ticketCreated);
    return "redirect:/employee/index";
    }
}
