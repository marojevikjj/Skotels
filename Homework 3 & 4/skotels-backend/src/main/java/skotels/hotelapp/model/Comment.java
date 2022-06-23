package skotels.hotelapp.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import skotels.hotelapp.DTO.HotelsCommentDTO;

import java.time.LocalDateTime;

@Data
@Document
public class Comment {

    @Id
    private ObjectId _id;

    private String comment;
    private String dateTime;
    private User user;
    private Hotels hotel;

    public Comment() {
    }

    public Comment(String comment, User user, Hotels hotel) {
        this._id = new ObjectId();
        this.comment = comment;
        this.user = user;
        this.hotel = hotel;
        this.dateTime = LocalDateTime.now().toString();
    }

    public static HotelsCommentDTO convertToDTO(Comment comment){
        return new HotelsCommentDTO(comment.getUser().getUsername(), comment.getDateTime(), comment.getComment(), comment.getHotel().getName());
    }
}
