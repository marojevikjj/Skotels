package skotels.hotelapp;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Users {

    @Id
    private ObjectId id;
    private String username;
    private String password;
    private boolean isAdmin;

    public Users() {
    }

    public Users(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.id = new ObjectId();
    }

}
