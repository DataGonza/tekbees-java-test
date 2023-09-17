package tekbees.microservices.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("travels")
public class Travel {

    @Id
    private String id;
    private String status;
    private NamedPlace country;
    private NamedPlace city;
    private Person passenger;
    private Person driver;
    private PickupInformation start;
    private PickupInformation end;
    private Car car;
    private Location driver_location;
    private String check_code;
    private Double price;
    private Date createdAt;
    private Date updatedAt;
}
