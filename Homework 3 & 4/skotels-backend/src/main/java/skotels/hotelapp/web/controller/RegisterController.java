package skotels.hotelapp.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skotels.hotelapp.service.UserService;
import skotels.hotelapp.model.Users;

@RestController
@RequestMapping("/api/signup")
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Users> signUp (@RequestBody Users newUser){
        return userService.save(newUser.getUsername(), newUser.getPassword(), newUser.isAdmin())
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
