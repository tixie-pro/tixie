package pro.tixie.controllers.user;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.tixie.model.*;
import pro.tixie.repos.*;
import pro.tixie.services.EmailService;

import java.util.List;

@Controller
public class EmployeeController {
    private UserRepository userDao;
    private TicketRepository ticketDao;
    private StatusRepository statusDao;
    private PriorityRepository priorDao;
    private SpecializationRepo specDao;
    private NoteRepository noteDao;
    private EmailService emailService;

    public EmployeeController(UserRepository userDao,
                              TicketRepository ticketDao,
                              StatusRepository statusDao,
                              PriorityRepository priorDao,
                              SpecializationRepo specDao,
                              NoteRepository noteDao,
                              EmailService emailService) {
        this.userDao = userDao;
        this.ticketDao = ticketDao;
        this.statusDao = statusDao;
        this.priorDao = priorDao;
        this.specDao = specDao;
        this.noteDao = noteDao;
        this.emailService = emailService;
    }


    @GetMapping("/employee/{id}")
    public String allTixByEmployee(
            @PathVariable long id,
            Model model,
            @PageableDefault(value=4) Pageable pageable) {
        User userTix = userDao.findOne(id);
        Ticket tixNote = ticketDao.findOne(id);
        List<Note> note = noteDao.findAllByTicket(tixNote);
        Status open= statusDao.findById(1);
        Status inProg = statusDao.findById(2);
        Status comp = statusDao.findById(3);

        if(ticketDao.findAllByOwnerAndStatus(userTix,open).size()>400) {
            model.addAttribute("page", ticketDao.findAllByOwnerAndStatus(userTix, open, pageable));
            model.addAttribute("pageable", true);
        }else{
            model.addAttribute("page", ticketDao.findAllByOwnerAndStatus(userTix, open));
            model.addAttribute("pageable", false);
        }
        if(ticketDao.findAllByOwnerAndStatus(userTix,inProg).size()>400) {
            model.addAttribute("page2", ticketDao.findAllByOwnerAndStatus(userTix, inProg, pageable));
            model.addAttribute("pageable2", true);
        }else{
            model.addAttribute("page2", ticketDao.findAllByOwnerAndStatus(userTix, inProg));
            model.addAttribute("pageable2", false);
        }
        if(ticketDao.findAllByOwnerAndStatus(userTix,comp).size()>400) {
            model.addAttribute("page3", ticketDao.findAllByOwnerAndStatus(userTix, comp, pageable));
            model.addAttribute("pageable3", true);
        }else{
            model.addAttribute("page3", ticketDao.findAllByOwnerAndStatus(userTix, comp));
            model.addAttribute("pageable3", false);
        }
        model.addAttribute("tix", ticketDao.findAllByAuthor(userTix));
        model.addAttribute("profile", userTix);
        model.addAttribute("employee", userDao);
        model.addAttribute("note", note);
        return ("user/employee/index");
    }

    @RequestMapping(value = {"/employee/ticket/create"})
    public String showTicketCreate(Model model, Status status, Specialization spec, Priority prior, Note note) {
        model.addAttribute("tix", new Ticket());
        model.addAttribute("status", status);
        model.addAttribute("spec", spec);
        model.addAttribute("priority", prior);
        model.addAttribute("note", note);
        return "user/employee/create_ticket";
    }


    @PostMapping("/employee/ticket/create")
    public String employeeTicketCreate(Model model, Ticket ticketCreated, Ticket ticket) {
        Status newStat = statusDao.findOne(1L);
        ticketCreated.setAuthorId((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        ticketCreated.setOwnerId((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        ticketCreated.setStatusId(newStat);
        ticketDao.save(ticketCreated);
        //emailService.prepareAndSend(ticket, "You created a ticket", "you did it!");
        return "redirect:/";
    }


}
