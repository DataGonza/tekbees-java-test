package tekbees.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tekbees.microservices.models.responses.CountResult;
import tekbees.microservices.services.TravelService;

@RestController
@RequestMapping(path = "/v1/travels/count")
public class TravelCountController {

    private final TravelService travelService;

    @Autowired
    public TravelCountController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public CountResult countAllTravels() {
        return travelService.countAllTravels();
    }

    @GetMapping("/country/{country}")
    public CountResult countTravelsByCountry(@PathVariable String country) {
        return travelService.countTravelsByCountry(country);
    }

    @GetMapping("/city/{city}")
    public CountResult countTravelsByCity(@PathVariable String city) {
        return travelService.countTravelsByCity(city);
    }
}
