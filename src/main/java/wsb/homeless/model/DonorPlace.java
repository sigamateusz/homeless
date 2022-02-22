package wsb.homeless.model;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
public class DonorPlace {
    String name;
    String desc;
    PlaceType type;
    String lat;
    String lng;
}
