package tekbees.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tekbees.microservices.models.responses.CountResult;
import tekbees.microservices.models.NamedPlace;
import tekbees.microservices.models.Travel;
import tekbees.microservices.persistence.TravelRepository;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    @Autowired
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public List<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    public CountResult countAllTravels() {
        return new CountResult(
                travelRepository.count()
        );
    }

    public CountResult countTravelsByCountry(String country) {
        return new CountResult(
                travelRepository.countByCountry(new NamedPlace(country))
        );
    }

    public CountResult countTravelsByCity(String city) {
        return new CountResult(
                travelRepository.countByCity(new NamedPlace(city))
        );
    }

    public void saveTravel(Travel travel) {
        travel.setCreatedAt(new Date());
        travelRepository.save(travel);
    }

    public void updateTravel(Travel travel) {

        String id = travel.getId();
        if (travelRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException(
                    String.format("Travel with id %s does not exist", id)
            );
        }

        Travel oldTravel = travelRepository.findById(id).get();
        travel.setCreatedAt(oldTravel.getCreatedAt());
        travel.setUpdatedAt(new Date());
        travelRepository.save(travel);
    }
}
