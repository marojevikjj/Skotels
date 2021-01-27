package com.skotels.hotelsservice.repository;

import com.skotels.hotelsservice.entity.Hotels;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelsRepository extends MongoRepository<Hotels, String> {
    List<Hotels> findAllByNameContains (String name);
    void deleteByName(String name);
}
