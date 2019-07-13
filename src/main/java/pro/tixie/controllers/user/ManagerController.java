package pro.tixie.controllers.user;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.tixie.model.User;
import pro.tixie.repos.TicketRepository;

@Controller
public class ManagerController {

    private TicketRepository ticketDao;

    public ManagerController(TicketRepository ticketDao){
        this.ticketDao = ticketDao;
    }

    @GetMapping("tickets/all")
    public String allTickets(Model model){

        User user = new User();

        model.addAttribute("tix", ticketDao.findAll());
        model.addAttribute("tix_author",ticketDao.findAllByAuthor(1l));
        model.addAttribute("tix_owner", ticketDao.findAllByOwner(2l));
        model.addAttribute("tix_priority", ticketDao.findAllByPriority(3));
        model.addAttribute("tix_spec", ticketDao.findAllBySpecialization(4));
        model.addAttribute("tix_statuys", ticketDao.findAllByStatus(5));
        return "view for all tickets";

    }

    @GetMapping("tickets/dashboard")
    public String statsTickets(){

        return "view for ticket stats";

    }



}
