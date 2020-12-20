package skotels.hotelapp;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("/edit/{id}")
    public ResponseEntity<Hotels> editHotelPage(@PathVariable String id){
        return this.hotelsRepository.findById(id).map(hotels ->
                ResponseEntity.ok().body(hotels)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public List<Hotels> saveHotel(@RequestBody Hotels hotel){
        System.out.println("No");
        this.hotelsRepository.save(hotel);
        System.out.println("Yes");
        return this.hotelsRepository.findAll();
    }

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
