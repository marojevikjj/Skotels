package com.skotels.hotelsservice.controller;
import com.skotels.hotelsservice.service.HotelsService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.skotels.hotelsservice.entity.Hotels;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class HotelsController {

    private final HotelsService hotelsService;

    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    // Return the hotels
    @GetMapping("/all")
    public List<Hotels> getAllHotels() {
        return this.hotelsService.listAll();
    }

    // Finds hotel by its id
    @GetMapping("/{id}")
    public Hotels getById(@RequestBody String _id){
        return this.hotelsService.findHotelById(_id).get();
    }

    // Find hotels by given name
    @PostMapping("/searchHotels")
    public List<Hotels> findAllByName(@RequestParam String search){
        return this.hotelsService.findHotelsByName(search);
    }


    // Save hotel in the db
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    public List<Hotels> saveHotel(@RequestBody Hotels hotel){
        return this.hotelsService.saveHotel(hotel);
    }

    // Delete hotel from the db
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete")
    public List<Hotels> deleteHotel(
            @RequestBody Hotels h){
        return this.hotelsService.deleteHotelByName(h.getName());
    }

    // Sort hotels by stars in descending order
    @GetMapping("/sortbystars")
    public List<Hotels> sortHotelsByStars(){
        return this.hotelsService.sortDescendingByStars();
    }

    // Sort hotels - alphabetic order
    @GetMapping("/sortalphabetic")
    public List<Hotels> sortHotelsAlphabetic() {
        return this.hotelsService.sortAscendingAlphabetic();
    }
}
