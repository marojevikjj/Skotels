package skotels.hotelapp.service;

import skotels.hotelapp.model.User;

public interface UserService {

    public Boolean existsByUsername(String username);
    public User save(User user);
}
