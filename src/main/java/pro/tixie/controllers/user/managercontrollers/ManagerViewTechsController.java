package pro.tixie.controllers.user.managercontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro.tixie.model.Note;
import pro.tixie.model.Ticket;
import pro.tixie.model.User;
import pro.tixie.repos.*;

import java.util.List;

@Controller
public class ManagerViewTechsController {

    private TicketRepository ticketDao;
    private UserRepository userDao;
    private PriorityRepository priDao;
    private StatusRepository statDao;
    private SpecializationRepo specDao;
    private NoteRepository noteDao;

    public ManagerViewTechsController(
            UserRepository userDao,
            TicketRepository ticketDao
    ){
        this.ticketDao = ticketDao;
        this.userDao = userDao;
        this.priDao = priDao;
        this.statDao= statDao;
        this.specDao = specDao;
        this.noteDao = noteDao;
    };

    @GetMapping("tech-list/all")
    public String showAllTechs(Model model){
        List<User> allTechs = userDao.findAll();
        List<Ticket> allTix = ticketDao.findAll();
        model.addAttribute("tix", allTix);
        model.addAttribute("techs", allTechs );
        model.addAttribute("x", 0);
        return "user/manager/tech-list";
    }


}
