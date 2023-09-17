package tekbees.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tekbees.microservices.models.Travel;
import tekbees.microservices.models.responses.ErrorResponse;
import tekbees.microservices.services.TravelService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/v1/travels")
public class TravelCRUDController {

    private final TravelService travelService;

    @Autowired
    public TravelCRUDController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public List<Travel> getTravels() {
        return travelService.getAllTravels();
    }

    @PostMapping
    public void saveTravel(@RequestBody Travel travel) {
        travelService.saveTravel(travel);
    }

    @PatchMapping("/{id}")
    public void updateTravel(@PathVariable String id, @RequestBody Travel travel) {
        travel.setId(id);
        travelService.updateTravel(travel);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchElementException(NoSuchElementException e) {
        return new ErrorResponse(e.getMessage());
    }
}
