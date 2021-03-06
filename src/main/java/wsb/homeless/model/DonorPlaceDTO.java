package wsb.homeless.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonorPlaceDTO {

    private String name;
    private String desc;
    private PlaceType type;
    private String lat;
    private String lng;

    public static DonorPlaceDTO fromEntity(DonorPlace donorPlace) {
        return DonorPlaceDTO.builder()
                .desc(donorPlace.getDesc())
                .lat(donorPlace.getLat())
                .lng(donorPlace.getLng())
                .type(donorPlace.getType())
                .name(donorPlace.getName())
                .build();
    }

    public DonorPlace toEntity() {
        return DonorPlace.builder()
                .desc(desc)
                .lng(lng)
                .lat(lat)
                .name(name)
                .type(type)
                .build();
    }
}
