package com.skotels.userservice.repository;

import com.skotels.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername (String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
}
