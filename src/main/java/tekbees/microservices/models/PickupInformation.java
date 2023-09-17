package tekbees.microservices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PickupInformation {
    private Date date;
    private String pickup_address;
    private Location pickup_location;
}
