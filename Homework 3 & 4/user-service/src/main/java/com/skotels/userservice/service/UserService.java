package com.skotels.userservice.service;

import com.skotels.userservice.model.User;

public interface UserService {
    Boolean existsByUsername(String username);
    User save(User user);
}
