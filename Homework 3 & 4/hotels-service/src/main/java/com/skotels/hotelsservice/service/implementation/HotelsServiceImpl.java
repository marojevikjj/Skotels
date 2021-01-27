package com.skotels.hotelsservice.service;

import com.skotels.hotelsservice.entity.Hotels;
import com.skotels.hotelsservice.repository.HotelsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelsService {

    private final HotelsRepository hotelsRepository;

    public HotelsService(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    // Searching hotel by given id

    public Optional<Hotels> findHotelById(String id) {
        if(hotelsRepository.findById(id).isPresent()){
            return hotelsRepository.findById(id);
        }
        return null;
    }

    // Searching hotel by given name

    public List<Hotels> findHotelsByName(String name) {
        return hotelsRepository.findAllByNameContains(name);
    }

    // Saving new hotel

    public List<Hotels> saveHotel(Hotels hotel) {
        this.hotelsRepository.save(hotel);
        return listAll();
    }

    // Returning list of all hotels

    public List<Hotels> listAll() {
        return this.hotelsRepository.findAll();
    }

    // Deleting hotel by given name

    public List<Hotels> deleteHotelByName(String name) {
        this.hotelsRepository.deleteByName(name);
        return listAll();
    }

    // Sorting hotels in descending order by stars

    public List<Hotels> sortDescendingByStars() {
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.DESC, "stars"));
    }

    // Sorting hotels in ascending order by name

    public List<Hotels> sortAscendingAlphabetic() {
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
