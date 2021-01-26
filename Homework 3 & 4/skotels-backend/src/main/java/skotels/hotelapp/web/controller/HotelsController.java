package skotels.hotelapp.web.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.repository.HotelsRepository;
import skotels.hotelapp.service.HotelsService;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HotelsController {

    private final HotelsService hotelsService;

    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @GetMapping
    public List<Hotels> getAllHotels() {
        return this.hotelsService.listAll();
    }

    @GetMapping("/{id}")
    public Hotels getById(@RequestBody String _id){
        return this.hotelsService.findHotelById(_id).get();
    }


    @PostMapping("/searchHotels")
    public List<Hotels> findAllByName(@RequestParam String search){
        return this.hotelsService.findHotelsByName(search);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public ResponseEntity<Hotels> editHotelPage(@PathVariable String id){
        return this.hotelsService.findHotelById(id).map(hotels ->
                ResponseEntity.ok().body(hotels)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    public List<Hotels> saveHotel(@RequestBody Hotels hotel){
//        System.out.println("No");
//        System.out.println("Yes");
        return this.hotelsService.saveHotel(hotel);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete")
    public List<Hotels> deleteHotel(
            @RequestBody Hotels h){
//        for (int i=0; i<this.hotelsRepository.findAll().size(); i++)
//            System.out.println(this.hotelsRepository.findAll().get(i));
        return this.hotelsService.deleteHotelByName(h.getName());
    }

    @GetMapping("/sortbystars")
    public List<Hotels> sortHotelsByStars(){
        return this.hotelsService.sortDescendingByStars();
    }

    @GetMapping("/sortbyprice")
    public List<Hotels> sortHotelsByPrice(){
        return this.hotelsService.sortAscendingByPrice();

    }
    @GetMapping("/sortalphabetic")
    public List<Hotels> sortHotelsAlphabetic() {
        return this.hotelsService.sortAscendingAlphabetic();
    }
}
