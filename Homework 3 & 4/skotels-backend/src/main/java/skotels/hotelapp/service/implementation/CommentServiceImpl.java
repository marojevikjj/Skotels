package skotels.hotelapp.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import skotels.hotelapp.DTO.HotelsCommentDTO;
import skotels.hotelapp.model.Comment;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.model.User;
import skotels.hotelapp.repository.CommentRepository;
import skotels.hotelapp.repository.HotelsRepository;
import skotels.hotelapp.service.CommentService;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final HotelsRepository hotelsRepository;

    @Override
    public List<Comment> findCommentsByHotel(Hotels hotel) {
        return this.commentRepository.findCommentsByHotel(hotel);
    }

    @Override
    public List<Hotels> addNewComment(String comm, User user, Hotels hotel) {
        Comment comment = new Comment(comm, user, hotel);
        this.commentRepository.save(comment);
        return this.hotelsRepository.findAll();
    }
}
