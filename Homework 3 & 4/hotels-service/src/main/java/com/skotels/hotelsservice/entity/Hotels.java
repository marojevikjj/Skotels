package com.skotels.hotelsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
