package com.example.testsplatform.controller;

import com.example.testsplatform.entity.Role;
import com.example.testsplatform.entity.User;
import com.example.testsplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class RegisterController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/register")
    public String showRegister() {
        return "pages-register";
    }

    @PostMapping("/register")
    public String validateRegister(@ModelAttribute("user") User user, @RequestParam("roleName") Role role, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/pages-register";
        }
        return userService.validateRegister(user, bindingResult, role);

    }

}
