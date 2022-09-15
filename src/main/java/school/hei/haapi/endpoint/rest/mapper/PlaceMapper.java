package school.hei.haapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Place;

@Component
@AllArgsConstructor
public class PlaceMapper {
    public Place toRest(school.hei.haapi.model.Place domainPlace) {
        return new Place()
                .idPlace(domainPlace.getId())
                .name(domainPlace.getName())
                .localisation(domainPlace.getLocalisation());
    }

    public school.hei.haapi.model.Place toDomain(Place restPlace) {
        return school.hei.haapi.model.Place.builder()
                .id(restPlace.getIdPlace())
                .name(restPlace.getName())
                .localisation(restPlace.getLocalisation())
                .build();
    }
}
