package skotels.hotelapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import skotels.hotelapp.model.Hotels;

import java.util.List;

@Repository
public interface HotelsRepository extends MongoRepository<Hotels, String> {
    List<Hotels> findAllByNameContains (String name);
    void deleteByName(String name);
}
