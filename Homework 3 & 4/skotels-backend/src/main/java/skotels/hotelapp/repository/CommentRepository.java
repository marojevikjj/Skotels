package skotels.hotelapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import skotels.hotelapp.model.Comment;
import skotels.hotelapp.model.Hotels;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> getCommentsByHotel(Hotels hotel);
    void deleteCommentsByHotel_Name(String name);
}
