package skotels.hotelapp.service;


import skotels.hotelapp.model.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> save (String username, String password, boolean isAdmin);
    Users register (String username, String password, boolean isAdmin);
    Optional<Users> findByUsername (String username);
    Optional<Users> findByUsernameAndPassword(String username, String password);
}
