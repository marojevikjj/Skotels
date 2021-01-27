package skotels.hotelapp.service;
import skotels.hotelapp.model.Hotels;

import java.util.List;
import java.util.Optional;

public interface HotelsService {
    Optional<Hotels> findHotelById(String id);
    List<Hotels> findHotelsByName(String name);
    List<Hotels> saveHotel(Hotels hotel);
    List<Hotels> listAll();
    List<Hotels> deleteHotelByName(String name);
    List<Hotels> sortDescendingByStars();
    List<Hotels> sortAscendingAlphabetic();
}