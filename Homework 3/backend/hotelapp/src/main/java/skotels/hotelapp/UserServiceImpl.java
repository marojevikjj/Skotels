package skotels.hotelapp;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Users> save(String username, String password) {
        return Optional.of(userRepository.save(new Users(username, password)));
    }

    @Override
    public Users register(String username, String password) {
        Users user = new Users(username,password);
        return userRepository.save(user);
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
