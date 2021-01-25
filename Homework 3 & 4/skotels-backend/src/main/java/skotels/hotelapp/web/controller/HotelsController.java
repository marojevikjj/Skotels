package skotels.hotelapp.web.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.repository.HotelsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HotelsController {

    private final HotelsRepository hotelsRepository;

    public HotelsController(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    @GetMapping
    public List<Hotels> getAllHotels() {
        return hotelsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hotels getById(@RequestBody String _id){
        if(hotelsRepository.findById(_id).isPresent()){
            return hotelsRepository.findById(_id).get();
        }
        return null;
    }

    @PostMapping("/searchHotels")
    public List<Hotels> findAllByName(@RequestParam String search){
        return hotelsRepository.findAllByNameContains(search);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public ResponseEntity<Hotels> editHotelPage(@PathVariable String id){
        return this.hotelsRepository.findById(id).map(hotels ->
                ResponseEntity.ok().body(hotels)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    public List<Hotels> saveHotel(@RequestBody Hotels hotel){
        System.out.println("No");
        this.hotelsRepository.save(hotel);
        System.out.println("Yes");
        return this.hotelsRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete")
    public List<Hotels> deleteHotel(
            @RequestBody Hotels h){
        this.hotelsRepository.deleteByName(h.getName());
        for (int i=0; i<this.hotelsRepository.findAll().size(); i++)
            System.out.println(this.hotelsRepository.findAll().get(i));
        return this.hotelsRepository.findAll();
    }

    @GetMapping("/sortbystars")
    public List<Hotels> sortHotelsByStars(){
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.DESC, "stars"));
    }
    @GetMapping("/sortbyprice")
    public List<Hotels> sortHotelsByPrice(){
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));

    }
    @GetMapping("/sortalphabetic")
    public List<Hotels> sortHotelsAlphabetic(@RequestBody String sortBy) {
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
