package skotels.hotelapp.web.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skotels.hotelapp.service.UserService;
import skotels.hotelapp.model.Users;

@RestController
@RequestMapping("/api/login")
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Users> login(@RequestBody Users loginUser){
        return userService.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword())
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
