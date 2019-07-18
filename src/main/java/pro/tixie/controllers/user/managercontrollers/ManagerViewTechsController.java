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
public class ManagerViewTechsController {

    private TicketRepository ticketDao;
    private UserRepository userDao;
    private PriorityRepository priDao;
    private StatusRepository statDao;
    private SpecializationRepo specDao;
    private NoteRepository noteDao;
    private RoleRepo roleDao;

    public ManagerViewTechsController(
            UserRepository userDao,
            TicketRepository ticketDao,
            RoleRepo roleDao,
            SpecializationRepo specDao
    ){
        this.ticketDao = ticketDao;
        this.userDao = userDao;
        this.priDao = priDao;
        this.statDao= statDao;
        this.specDao = specDao;
        this.noteDao = noteDao;
        this.roleDao = roleDao;
    };

    @GetMapping("tech-list/all")
    public String showAllTechs(Model model){
        List<User> allTechs = userDao.findAll();
        List<Ticket> allTix = ticketDao.findAll();
        List<Role> roles = roleDao.findAll();
        List<Specialization> allSpecs = specDao.findAll();
        model.addAttribute("tix", allTix);
        model.addAttribute("techs", allTechs );
        model.addAttribute("roles", roles);
        model.addAttribute("specs", allSpecs);
        model.addAttribute("x", 0);

        return "user/manager/tech-list";
    }

    @PostMapping("change-role")
    public String changeRole(
            @RequestParam(name = "role") long newRoleId,
            @RequestParam(name= "changespec") long newSpecId,
            @RequestParam(name = "techid") long techId
    ){
        User tech = userDao.findOne(techId);
        Role newRole = roleDao.findOne(newRoleId);
        Specialization newSpec = specDao.findOne(newSpecId);
        tech.setRole(newRole);
        tech.setSpecialization(newSpec);
        userDao.save(tech);
        return "redirect:/tech-list/all";

    }



}
