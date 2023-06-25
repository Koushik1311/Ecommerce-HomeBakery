package com.homebakery.homebakery.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homebakery.homebakery.dto.UserDto;
import com.homebakery.homebakery.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = userService.fiindAllUsers();
        model.addAttribute("users", users);
        return "admin/users"; // returns the users.html which is on "resourses/template/admin"
    }
}
