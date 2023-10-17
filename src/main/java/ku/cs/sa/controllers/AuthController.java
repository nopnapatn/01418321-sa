package ku.cs.sa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ku.cs.sa.models.SignupRequest;
import ku.cs.sa.services.AuthService;

@Controller
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/signup")
    public String getSignupPage() {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute SignupRequest user, Model model) {
        if (authService.isUsernameAvaliable(user.getUsername())) {
            authService.createUser(user);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        return "auth/signup";
    }

    @GetMapping("/login")
    public String loginView() {
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
            HttpServletResponse response,
            Authentication auth) {

        if (auth != null) {
            new SecurityContextLogoutHandler()
                    .logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
