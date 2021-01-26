package skotels.hotelapp.service.implementation;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import skotels.hotelapp.model.Hotels;
import skotels.hotelapp.repository.HotelsRepository;
import skotels.hotelapp.service.HotelsService;

import java.util.List;
import java.util.Optional;

@Service
public class HotelsServiceImpl implements HotelsService {

    private final HotelsRepository hotelsRepository;

    public HotelsServiceImpl(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    @Override
    public Optional<Hotels> findHotelById(String id) {
        if(hotelsRepository.findById(id).isPresent()){
            return hotelsRepository.findById(id);
        }
        return null;
    }

    @Override
    public List<Hotels> findHotelsByName(String name) {
        return hotelsRepository.findAllByNameContains(name);
    }

    @Override
    public List<Hotels> saveHotel(Hotels hotel) {
        this.hotelsRepository.save(hotel);
        return listAll();
    }

    @Override
    public List<Hotels> listAll() {
        return this.hotelsRepository.findAll();
    }

    @Override
    public List<Hotels> deleteHotelByName(String name) {
        this.hotelsRepository.deleteByName(name);
        return listAll();
    }

    @Override
    public List<Hotels> sortAscendingByPrice() {
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    @Override
    public List<Hotels> sortDescendingByStars() {
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.DESC, "stars"));
    }

    @Override
    public List<Hotels> sortAscendingAlphabetic() {
        return this.hotelsRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
