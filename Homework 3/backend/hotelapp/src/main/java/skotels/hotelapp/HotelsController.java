package skotels.hotelapp;

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
    public List<Hotels> listAll(){
        return hotelsRepository.findAll();
    }

    @PostMapping("/searchHotels")
    public List<Hotels> findAllByName(@RequestParam String search){
        return hotelsRepository.findAllByNameContains(search);
    }
}
