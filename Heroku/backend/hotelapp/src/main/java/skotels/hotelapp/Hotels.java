package skotels.hotelapp;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Hotels {

    @Id
    private ObjectId _id;

    private String name;
    private String email;
    private String location;
    private String internet_access;
    private String rooms;
    private String phone;
    private String website;
    private String stars;
    private String latitude;
    private String longitude;

    public Hotels() {
    }

    public Hotels(String name, String email, String location, String internet_access,
                  String rooms, String phone, String website, String stars, String latitude,
                  String longitude) {
        this._id = new ObjectId();
        this.name = name;
        this.email = email;
        this.location = location;
        this.internet_access = internet_access;
        this.rooms = rooms;
        this.phone = phone;
        this.website = website;
        this.stars = stars;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
