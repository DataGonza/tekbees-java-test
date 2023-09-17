package tekbees.microservices.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import tekbees.microservices.models.NamedPlace;
import tekbees.microservices.models.Travel;

public interface TravelRepository extends MongoRepository<Travel, String> {
    long countByCountry(NamedPlace country);
    long countByCity(NamedPlace city);
}
