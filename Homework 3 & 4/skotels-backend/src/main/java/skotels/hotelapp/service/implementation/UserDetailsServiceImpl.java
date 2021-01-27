package skotels.hotelapp.service.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skotels.hotelapp.model.User;
import skotels.hotelapp.repository.UserRepository;
import skotels.hotelapp.service.UserService;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
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
