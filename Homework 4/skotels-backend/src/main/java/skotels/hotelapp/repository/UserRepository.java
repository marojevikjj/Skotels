package skotels.hotelapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import skotels.hotelapp.model.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
    Optional<Users> findByUsername (String username);
    Optional<Users> findByUsernameAndPassword(String username, String password);
}
