package skotels.hotelapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelsCommentDTO {

    private String username;
    private String time;
    private String comment;
    private String hotelName;

    public HotelsCommentDTO(String username, String time, String comment, String hotelName) {
        this.username = username;
        this.time = time;
        this.comment = comment;
        this.hotelName = hotelName;
    }
}