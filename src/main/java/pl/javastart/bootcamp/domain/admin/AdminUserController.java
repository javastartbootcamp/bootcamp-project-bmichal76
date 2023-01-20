package pl.javastart.bootcamp.domain.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.javastart.bootcamp.domain.user.User;
import pl.javastart.bootcamp.domain.user.UserService;
import pl.javastart.bootcamp.domain.user.UserWithAdminRole;

import java.util.List;

@Controller
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/uzytkownicy")
    public String users(Model model) {
        List<UserWithAdminRole> users = userService.getAllUsersWithAdminIndicator();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/admin/uzytkownicy/{id}")
    public String user(Model model, @PathVariable Long id) {
        User user = userService.findByIdOrThrow(id);
        model.addAttribute("user", user);
        return "admin/user";
    }

    @GetMapping("/admin/uzytkownicy/odbierz/{id}")
    public String dismissAdmin(@PathVariable Long id) {
        userService.dismissAdmin(id);
        return "redirect:/admin/uzytkownicy";
    }

    @GetMapping("/admin/uzytkownicy/nadaj/{id}")
    public String addAdmin(@PathVariable Long id) {
        User user = userService.findByIdOrThrow(id);
        userService.addAdmin(user);
        return "redirect:/admin/uzytkownicy";
    }
}
