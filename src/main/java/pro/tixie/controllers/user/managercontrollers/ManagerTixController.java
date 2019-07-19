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
        nulUserIf(tix);
        model.addAttribute("tix", tix);
        return "user/manager/tickets";
    }

    @GetMapping("tickets/tech/{id}")
    public String allTicketsbyTech(@PathVariable long id, Model model){
        User user = userDao.findOne(id);
        List<Ticket> tix = ticketDao.findAllByOwner(user);
        nulUserIf(tix);
        model.addAttribute("tix", tix);
        return "user/manager/tickets";
    }

    @GetMapping("tickets/author/{id}")
    public String allTicketsbyAuthor(@PathVariable long id, Model model){
        User user = userDao.findOne(id);
        List<Ticket> tix = ticketDao.findAllByAuthor(user);
        nulUserIf(tix);
        model.addAttribute("tix", tix);
        return "user/manager/tickets";
    }

    @GetMapping("tickets/priority/{id}")
    public String allTicketsbyPriority(@PathVariable long id, Model model){
        Priority pri = priDao.findOne(id);
        List<Ticket>tix = ticketDao.findAllByPriority(pri);
        nulUserIf(tix);
        model.addAttribute("tix", tix);
        return "user/manager/tickets";
    }

    @GetMapping("tickets/status/{id}")
    public String allTicketsByStatus(@PathVariable long id, Model model){
        Status stat = statDao.findOne(id);
        List<Ticket> tix = ticketDao.findAllByStatus(stat);
        model.addAttribute("tix", tix);
        return "user/manager/tickets";
    }

    @GetMapping("tickets/specialization/{id}")
    public String allTickstsBySpec(@PathVariable long id, Model model){
        Specialization spec = specDao.findOne(id);
        List<Ticket> tix = ticketDao.findAllBySpecialization(spec);
        model.addAttribute("tix", tix);
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
        List<User> allTechs = userDao.findAll();
        List<Note> note = noteDao.findAllByTicket(tix);
        List<Ticket> allTix = ticketDao.findAll();
        model.addAttribute("active", true);
        model.addAttribute("ticket", tix);
        model.addAttribute("note", note);
        model.addAttribute("techs", allTechs);
        model.addAttribute("tix", allTix);
        return "user/technician/index";
    }
    @PostMapping("techreassign")
    public String techTixReassign(
            @RequestParam (name = "assign") long id,
            @RequestParam (name = "ticketid") long tixId
            ){

        Ticket tix = ticketDao.findOne(tixId);
        User owner = userDao.findOne(id);

        tix.setOwnerId(owner);
        ticketDao.save(tix);
            return ("redirect:/tech/ticket/"+tixId);
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

    @PostMapping("/techticket/inprogress")
    public String inProgressTicket(
            @RequestParam (name = "ticketIdIp") long id,
            @RequestParam (name = "statusIp") long statIdIp){

        Status ipStat = statDao.findOne(statIdIp);
        Ticket ipTick = ticketDao.findOne(id);

        ipTick.setStatusId(ipStat);
        ticketDao.save(ipTick);

        return "redirect:/tech/ticket/" +id;

    }

    public List<Ticket> nulUserIf(List<Ticket> tix){
        for (Ticket ticket:tix){
            if (ticket.getOwnerId()==null){
                User nullUser = new User();
                nullUser.setFirstName("Not");
                nullUser.setLastName("Assigned");
                nullUser.setUserName("Not Assiged");
                ticket.setOwnerId(nullUser);
            }
        }
        return tix;
    }

}
