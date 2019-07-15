package pro.tixie.controllers.user.managercontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro.tixie.model.*;
import pro.tixie.repos.*;

import java.util.List;

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
//        all graphs will just be numerical stats for now
//        one section for stats of all tickets
//        one graph for tickets by status
//        open = 1 in progress = 2 complete = 3
        Status comp = statDao.findById(3);
        Status inProg= statDao.findById(2);
        Status open= statDao.findById(1);

//        carpenter = 1 electric = 2 plumbing =3 hvac = 4 custodian = 5 biohazard = 6

        Specialization carp = specDao.findById(1);
        Specialization elec = specDao.findById(2);
        Specialization plum = specDao.findById(3);
        Specialization hvac = specDao.findById(4);
        Specialization cust = specDao.findById(5);
        Specialization bioh = specDao.findById(6);
//        creating the lists
        List<Ticket> allTix = ticketDao.findAll();
        List<Ticket> compTix = ticketDao.findAllByStatus(comp);
        List<Ticket> inProgTix= ticketDao.findAllByStatus(inProg);
        List<Ticket> openTix= ticketDao.findAllByStatus(open);

        List<Ticket> carpTix = ticketDao.findAllBySpecialization(carp);
        List<Ticket> elecTix = ticketDao.findAllBySpecialization(elec);
        List<Ticket> plumTix = ticketDao.findAllBySpecialization(plum);
        List<Ticket> hvacTix = ticketDao.findAllBySpecialization(hvac);
        List<Ticket> custTix = ticketDao.findAllBySpecialization(cust);
        List<Ticket> biohTix = ticketDao.findAllBySpecialization(bioh);

//        String totalTix=

        model.addAttribute("totalTix", allTix.size() );
        model.addAttribute("complete", compTix.size());
        model.addAttribute("completePerc",percentCalc(compTix.size(), allTix.size()));
        model.addAttribute("inProg", inProgTix.size());
        model.addAttribute("inProgPerc", percentCalc(inProgTix.size(), allTix.size()));
        model.addAttribute("open", openTix.size());
        model.addAttribute("openPerc", percentCalc(openTix.size(), allTix.size()));
//        one graph for tickets by catagory



//        one graph for tickets by time line.


        return "user/manager/dashboard";
    }

    @GetMapping("dashboard/roles/{id}")
    public String dashRoles(@PathVariable long id,Model model){
        return "Roles dash view";
    }

    @GetMapping("dashboard/specialization/{id}")
    public String dashSpecialization(@PathVariable long id,Model model){
        return "Spec dash view";
    }

//    Helper methods

    public double percentCalc(double tix, double totaltix) {
        return tix * 100 / totaltix;
    }

}
