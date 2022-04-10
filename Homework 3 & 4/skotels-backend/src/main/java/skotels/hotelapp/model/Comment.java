package skotels.hotelapp.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document
public class Comment {

    @Id
    private ObjectId _id;

    private String comment;
    @CreatedDate
    private LocalDateTime createdAt;
    private Hotels hotel;
    private User user;

    public Comment(String comment, Hotels hotel, User user) {
        this._id = new ObjectId();
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
        this.hotel = hotel;
        this.user = user;
    }
}
