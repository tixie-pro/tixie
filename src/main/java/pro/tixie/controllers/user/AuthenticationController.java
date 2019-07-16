package pro.tixie.controllers.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String usersLoginForm() {
        return "user/login";
    }
}
