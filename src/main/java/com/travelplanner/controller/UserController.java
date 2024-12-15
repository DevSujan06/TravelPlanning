package com.travelplanner.controller;

import com.travelplanner.model.Booking;
import com.travelplanner.model.User;
import com.travelplanner.service.BookingService;
import com.travelplanner.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private BookingService bookingService;

    @GetMapping("/bookings")
    public String viewUserBookings(@RequestParam String userId, Model model) {
        List<Booking> bookings = BookingService.getBookingsByUserId(userId);
        model.addAttribute("bookings", bookings);
        return "user-profile"; // Adjust to the correct template if necessary
    }
    // Render user profile page
    @GetMapping("/profile")
    public String getProfile(@RequestParam(required = false) String email, Model model) {
        if (email == null || email.isEmpty()) {
            model.addAttribute("error", "Email parameter is missing or empty.");
            return "error"; // Render error.html with the error message
        }

        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isEmpty()) {
            model.addAttribute("error", "User not found.");
            return "error"; // Render error.html if the user is not found
        }

        model.addAttribute("user", userOptional.get()); // Pass the user object to the template
        return "profile"; // Render profile.html
    }

    // Handle updating user profile
    @PutMapping("/profile")
    public String updateProfile(@ModelAttribute User user, Model model) {
        if (user == null || user.getId() == null) {
            model.addAttribute("error", "Invalid user data.");
            return "error";
        }

        try {
            User updatedUser = userService.updateUser(user);
            model.addAttribute("user", updatedUser);
            model.addAttribute("message", "Profile updated successfully.");
            return "profile"; // Redirect to profile.html with the updated user data
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
