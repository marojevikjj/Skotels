package skotels.hotelapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import skotels.hotelapp.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername (String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
}
