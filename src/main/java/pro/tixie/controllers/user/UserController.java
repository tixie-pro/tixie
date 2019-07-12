package pro.tixie.controllers.user;

import org.springframework.stereotype.Controller;
import pro.tixie.repos.UserRepository;

@Controller
public class UserController {
    private UserRepository userDao;

    public UserController (UserRepository userDao) {
        this.userDao = userDao;
    }


}
