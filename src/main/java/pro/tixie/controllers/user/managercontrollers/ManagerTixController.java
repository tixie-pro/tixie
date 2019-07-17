package pro.tixie.controllers.user.managercontrollers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.tixie.model.*;
import pro.tixie.repos.*;

import java.util.List;

@Controller
public class ManagerTixController {

    private TicketRepository ticketDao;
    private UserRepository userDao;
    private PriorityRepository priDao;
    private StatusRepository statDao;
    private SpecializationRepo specDao;
    private NoteRepository noteDao;

    public ManagerTixController(TicketRepository ticketDao,
                             UserRepository userDao,
                             PriorityRepository priDao,
                             StatusRepository statDao,
                             SpecializationRepo specDao,
                             NoteRepository noteDao
    ){
        this.ticketDao = ticketDao;
        this.userDao = userDao;
        this.priDao = priDao;
        this.statDao= statDao;
        this.specDao = specDao;
        this.noteDao = noteDao;
    }

    @GetMapping("tickets/all")
    public String allTickets(Model model){

//        User user = new User();
        List<Ticket> tix = ticketDao.findAll();
        model.addAttribute("tix", tix);
//        model.addAttribute("tix_author",ticketDao.findAllByAuthor(1l));
//        model.addAttribute("tix_owner", ticketDao.findAllByOwner(2l));
//        model.addAttribute("tix_priority", ticketDao.findAllByPriority(3));
//        model.addAttribute("tix_spec", ticketDao.findAllBySpecialization(4));
//        model.addAttribute("tix_statuys", ticketDao.findAllByStatus(5));
        return "user/manager/tickets";
    }

    @GetMapping("tickets/tech/{id}")
    public String allTicketsbyTech(@PathVariable long id, Model model){
        User user = userDao.findOne(id);
        model.addAttribute("tix", ticketDao.findAllByOwner(user));
        return "user/manager/tickets";
    }

    @GetMapping("tickets/author/{id}")
    public String allTicketsbyAuthor(@PathVariable long id, Model model){
        User user = userDao.findOne(id);
        model.addAttribute("tix", ticketDao.findAllByAuthor(user));
        return "user/manager/tickets";
    }

    @GetMapping("tickets/priority/{id}")
    public String allTicketsbyPriority(@PathVariable long id, Model model){
        Priority pri = priDao.findOne(id);
        model.addAttribute("tix", ticketDao.findAllByPriority(pri));
        return "user/manager/tickets";
    }

    @GetMapping("tickets/status/{id}")
    public String allTicketsByStatus(@PathVariable long id, Model model){
        Status stat = statDao.findOne(id);
        model.addAttribute("tix", ticketDao.findAllByStatus(stat));
        return "user/manager/tickets";
    }

    @GetMapping("tickets/specialization/{id}")
    public String allTickstsBySpec(@PathVariable long id, Model model){
        Specialization spec = specDao.findOne(id);
        model.addAttribute("tix", ticketDao.findAllBySpecialization(spec));
        return "user/manager/tickets";
    }

    @GetMapping("tickets/dashboard")
    public String statsTickets(){

        return "view for ticket stats";

    }

    @GetMapping("/tech")
    public String techPage(Model model){
        List<Ticket> tix = ticketDao.findAll();
        model.addAttribute("tix", tix);
        model.addAttribute("active", false);
        return "user/technician/index";
    }

    @GetMapping("tech/ticket/{id}")
    public String techTicket(@PathVariable long id, Model model){
        Ticket tix = ticketDao.findOne(id);
        List<Note> note = noteDao.findAllByTicket(tix);
        List<Ticket> allTix = ticketDao.findAll();
        model.addAttribute("active", true);
        model.addAttribute("ticket", tix);
        model.addAttribute("note", note);
        model.addAttribute("tix", allTix);
        return "user/technician/index";
    }

    @PostMapping("/techticketcomplete")
    public String completeTicket(
            @RequestParam (name = "ticketId") Long id,
            @RequestParam (name = "status") Long statId){

                Status newStat = statDao.findOne(statId);
                Ticket tick = ticketDao.findOne(id);

                tick.setStatusId(newStat);
                ticketDao.save(tick);

                return "redirect:/tech";

    }



}
