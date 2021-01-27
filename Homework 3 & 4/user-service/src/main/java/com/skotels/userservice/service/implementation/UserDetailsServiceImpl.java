package com.skotels.userservice.service.implementation;

import com.skotels.userservice.model.User;
import com.skotels.userservice.repository.UserRepository;
import com.skotels.userservice.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {


    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    public Optional<User> findByUsernameAndPassword(String username, String password){
        return this.userRepository.findByUsernameAndPassword(username, password);
    }

    // Checking if there is already a user with a given username

    @Override
    public Boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    // Saving new user
    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }
}
