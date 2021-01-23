package skotels.hotelapp.model;

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
    private String internetAccess;
    private String rooms;
    private String phone;
    private String website;
    private String stars;
    private String latitude;
    private String longitude;
    private String address;

    public Hotels() {
    }

    public Hotels(String name, String email, String location, String internetAccess,
                  String rooms, String phone, String website, String stars, String latitude,
                  String longitude, String address) {
        this._id = new ObjectId();
        this.name = name;
        this.email = email;
        this.location = location;
        this.internetAccess = internetAccess;
        this.rooms = rooms;
        this.phone = phone;
        this.website = website;
        this.stars = stars;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }
}
