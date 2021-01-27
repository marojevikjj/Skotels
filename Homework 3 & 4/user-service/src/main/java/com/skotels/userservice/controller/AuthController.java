package com.skotels.userservice.controller;

import com.skotels.userservice.model.User;
import com.skotels.userservice.payload.MessageResponse;
import com.skotels.userservice.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {


    private final UserDetailsServiceImpl userService;
    private final PasswordEncoder encoder;

    public AuthController(UserDetailsServiceImpl userService,
                          PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String encodedPassword = this.userService.loadUserByUsername(username).getPassword();

        if (this.encoder.matches(password, encodedPassword)){
            User user1 = this.userService.findByUsernameAndPassword(username, encodedPassword)
                    .orElseThrow(() -> new RuntimeException("InvalidUserCredentials"));
            return ResponseEntity.ok().body(user1);
        }

        return ResponseEntity.ok().body(new MessageResponse("Invalid user credentials"));
    }

    @PostMapping("/api/signup")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) {
        if (this.userService.existsByUsername(newUser.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        // Create new user's account
        String username = newUser.getUsername();
        String password = this.encoder.encode(newUser.getPassword());
        if (newUser.getRole() == null){
            this.userService.save(new User(username, password, "ROLE_USER"));
        }
        else if (newUser.getRole().equals("ROLE_ADMIN")) {
            this.userService.save(new User(username, password, "ROLE_ADMIN"));
        }
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/api/logout")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> logoutUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
        return ResponseEntity.ok(new MessageResponse("logout successful"));
    }
}