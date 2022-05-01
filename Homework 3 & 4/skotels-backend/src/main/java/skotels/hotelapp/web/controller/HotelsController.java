package skotels.hotelapp.web.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.repository.HotelsRepository;
import skotels.hotelapp.service.HotelsService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HotelsController {

    private final HotelsService hotelsService;

    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    // Return the hotels
    @GetMapping
    public List<Hotels> getAllHotels() {
        return this.hotelsService.listAll();
    }

    // Finds hotel by its id
    @GetMapping("/{id}")
    public Hotels getById(@PathVariable String id){
        Optional<Hotels> h = this.hotelsService.findHotelById(id);
        return this.hotelsService.findHotelById(id).get();
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
