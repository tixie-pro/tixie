package pro.tixie.controllers.user.managercontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro.tixie.model.Note;
import pro.tixie.model.Role;
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
    private RoleRepo roleRepo;

    public ManagerViewTechsController(
            UserRepository userDao,
            TicketRepository ticketDao,
            RoleRepo roleDao
    ){
        this.ticketDao = ticketDao;
        this.userDao = userDao;
        this.priDao = priDao;
        this.statDao= statDao;
        this.specDao = specDao;
        this.noteDao = noteDao;
        this.roleRepo = roleDao;
    };

    @GetMapping("tech-list/all")
    public String showAllTechs(Model model){
        List<User> allTechs = userDao.findAll();
        List<Ticket> allTix = ticketDao.findAll();
        List<Role> roles = roleRepo.findAll();
        model.addAttribute("tix", allTix);
        model.addAttribute("techs", allTechs );
        model.addAttribute("roles", roles);
        model.addAttribute("x", 0);

        return "user/manager/tech-list";
    }


//    helper functions

//    public int tixCount(List<Ticket> allTix, long id){
//        int x = 0;
//        for (Ticket ticket:allTix){
//            if (ticket.getOwnerId().equals(id)){
//                x++;
//            }
//        }
//        return x;
//    }

}
