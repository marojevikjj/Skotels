package skotels.hotelapp;


import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {
    Optional<Users> save (String username, String password);
    Users register (String username, String password);
    Optional<Users> findByUsername (String username);
}
