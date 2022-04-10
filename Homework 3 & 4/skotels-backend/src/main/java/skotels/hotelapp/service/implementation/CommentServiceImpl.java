package skotels.hotelapp.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skotels.hotelapp.model.Comment;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.model.User;
import skotels.hotelapp.repository.CommentRepository;
import skotels.hotelapp.repository.HotelsRepository;
import skotels.hotelapp.repository.UserRepository;
import skotels.hotelapp.service.CommentService;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final HotelsRepository hotelsRepository;
    private final UserRepository userRepository;

    @Override
    public List<Comment> getAllHotelComments(String hotelId) {
        Hotels hotel = this.hotelsRepository.findById(hotelId).orElseThrow(IllegalArgumentException::new);
        return this.commentRepository.getCommentsByHotel(hotel);
    }

    @Override
    public List<Comment> addNewComment(Hotels hotel, User user, String comment) {
        Comment newComment = new Comment(comment, hotel, user);
        this.commentRepository.save(newComment);
        return this.commentRepository.getCommentsByHotel(hotel);
    }

    @Override
    public List<Comment> deleteComment(String commentId) {
        Comment comment = this.commentRepository.findById(commentId).get();
        this.commentRepository.delete(comment);
        return this.commentRepository.getCommentsByHotel(comment.getHotel());
    }
}
