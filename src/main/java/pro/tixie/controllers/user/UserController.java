package pro.tixie.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pro.tixie.model.User;
import pro.tixie.repos.RoleRepo;
import pro.tixie.repos.SpecializationRepo;
import pro.tixie.repos.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private RoleRepo roleRepo;
    private SpecializationRepo specRepo;


    public UserController (UserRepository userDao,
                           PasswordEncoder passwordEncoder,
                           RoleRepo roleRepo,
                           SpecializationRepo specRepo) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
        this.specRepo = specRepo;

    }

    @GetMapping("/register")
    private String create(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepo.findAll());
        model.addAttribute("specs", specRepo.findAll());
        return "user/registration";
    }

//    @GetMapping("/redirect")
//    private String redirectUser() {
//            return
//    }

    @PostMapping("/register")
    private String insert(@ModelAttribute User user){

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setConfirmPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }
}