package com.travelplanner.controller;

import com.travelplanner.dto.UserRegistrationDTO;
import com.travelplanner.model.User;
import com.travelplanner.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Render the registration page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("registrationDTO", new UserRegistrationDTO()); // Bind empty DTO for form
        return "register"; // Refers to register.html in templates
    }

    // Handle user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registrationDTO") UserRegistrationDTO registrationDTO, Model model) {
        try {
            User user = authService.registerUser(registrationDTO);
            model.addAttribute("message", "Registration successful! Please log in.");
            return "redirect:/auth/login"; // Redirect to login.html after successful registration
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register"; // Stay on the registration page if there's an error
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred. Please try again.");
            return "register";
        }
    }

    // Render the login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login"; // Refers to login.html in templates
    }

    // Handle user login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            boolean isAuthenticated = authService.authenticateUser(email, password);
            if (isAuthenticated) {
                return "redirect:/"; // Redirect to the home page or dashboard on successful login
            } else {
                model.addAttribute("error", "Invalid credentials. Please try again.");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred. Please try again.");
            return "login";
        }
    }
}
