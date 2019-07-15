package pro.tixie.controllers.user.managercontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro.tixie.model.*;
import pro.tixie.repos.*;

@Controller
public class ManagerDashController {

    private TicketRepository ticketDao;
    private UserRepository userDao;
    private PriorityRepository priDao;
    private StatusRepository statDao;
    private SpecializationRepo specDao;

    public ManagerDashController(TicketRepository ticketDao,
                                UserRepository userDao,
                                PriorityRepository priDao,
                                StatusRepository statDao,
                                SpecializationRepo specDao
    ){
        this.ticketDao = ticketDao;
        this.userDao = userDao;
        this.priDao = priDao;
        this.statDao= statDao;
        this.specDao = specDao;
    }

    @GetMapping("dashboard/all")
    public String dashAll(Model model){
        return "full dash view";
    }

    @GetMapping("dashboard/roles/{id}")
    public String dashRoles(@PathVariable long id,Model model){
        return "Roles dash view";
    }

    @GetMapping("dashboard/specialization/{id}")
    public String dashSpecialization(@PathVariable long id,Model model){
        return "Spec dash view";
    }

}
