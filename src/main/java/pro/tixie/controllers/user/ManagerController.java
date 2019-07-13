package pro.tixie.controllers.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.tixie.repos.TicketRepository;

@Controller
public class ManagerController {

    private TicketRepository ticketDao;

    public ManagerController(TicketRepository ticketDao){
        this.ticketDao = ticketDao;
    }

    @GetMapping("tickets/all")
    public String allTickets(Model model){
//        model.addAttribute("tix", ticketDao.findAll());
//        model.addAttribute("tix_author",ticketDao.findAllByAuthorId(1));
//        model.addAttribute("tix_owner", ticketDao.findAllByOwnerId(1));
//        model.addAttribute("tix_priority", ticketDao.findAllByPriorityId(1));
//        model.addAttribute("tix_spec", ticketDao.findAllBySpecializationId(1));
//        model.addAttribute("tix_statuys", ticketDao.findAllByStatusId(1));
        return "view for all tickets";

    }

    @GetMapping("tickets/dashboard")
    public String statsTickets(){

        return "view for ticket stats";

    }



}
