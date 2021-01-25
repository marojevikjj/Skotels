package skotels.hotelapp.web.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import skotels.hotelapp.payload.MessageResponse;
import skotels.hotelapp.repository.UserRepository;
import skotels.hotelapp.model.User;
import skotels.hotelapp.service.implementation.UserDetailsImpl;
import skotels.hotelapp.service.implementation.UserDetailsServiceImpl;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    //private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userService;
    //private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    //private final JwtUtils jwtUtils;

    public AuthController(//AuthenticationManager authenticationManager,
                          UserDetailsServiceImpl userService,
                          //RoleRepository roleRepository,
                          PasswordEncoder encoder
                          /*JwtUtils jwtUtils*/) {
        //this.authenticationManager = authenticationManager;
        this.userService = userService;
        //this.roleRepository = roleRepository;
        this.encoder = encoder;
        //this.jwtUtils = jwtUtils;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String encodedPassword = this.userService.loadUserByUsername(username).getPassword();
        if (this.encoder.matches(password, encodedPassword)){
            System.out.println("passwords match");
            User user1 = this.userService.findByUsernameAndPassword(username, encodedPassword)
                    .orElseThrow(() -> new RuntimeException("InvalidUserCredentials"));
            return ResponseEntity.ok().body(user1);
        }
        return ResponseEntity.notFound().build();

        //Authentication authentication = authenticationManager.authenticate(
        //        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        //String jwt = jwtUtils.generateJwtToken(authentication);
//
        //UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        //List<String> roles = userDetails.getAuthorities().stream()
        //        .map(item -> item.getAuthority())
        //        .collect(Collectors.toList());

        //return ResponseEntity.ok(new JwtResponse(jwt,
        //        userDetails.getId(),
        //        userDetails.getUsername(),
        //        roles));
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
    public ResponseEntity logoutUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
        return ResponseEntity.ok(new MessageResponse("logout successful"));
    }
}