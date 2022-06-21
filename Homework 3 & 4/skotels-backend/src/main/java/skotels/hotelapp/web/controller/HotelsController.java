package skotels.hotelapp.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import skotels.hotelapp.DTO.HotelsCommentDTO;
import skotels.hotelapp.model.Comment;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.model.User;
import skotels.hotelapp.service.CommentService;
import skotels.hotelapp.service.HotelsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotels")
//@CrossOrigin(origins = "https://skotels.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HotelsController {

    private final HotelsService hotelsService;
    private final CommentService commentService;

    public HotelsController(HotelsService hotelsService, CommentService commentService) {
        this.hotelsService = hotelsService;
        this.commentService = commentService;
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

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/saveComment")
    public List<Hotels> addNewComment(@RequestBody HotelsCommentDTO comment, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return this.commentService.addNewComment(comment.getComment(), user,
                this.hotelsService.findHotelByName(comment.getHotelName()).get());
    }

    @GetMapping("/getComments")
    public List<HotelsCommentDTO> getComments(@RequestBody Hotels hotel){

        List<HotelsCommentDTO> comments = this.commentService.findCommentsByHotel(hotel)
                .stream().map(Comment::convertToDTO).collect(Collectors.toList());
        return comments;
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
