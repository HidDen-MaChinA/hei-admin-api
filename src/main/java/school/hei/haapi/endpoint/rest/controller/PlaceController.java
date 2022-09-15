package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.PlaceMapper;
import school.hei.haapi.endpoint.rest.model.Place;
import school.hei.haapi.service.PlaceService;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
@AllArgsConstructor
public class PlaceController {
    private final PlaceService service;

    private final PlaceMapper mapper;

    @GetMapping("/places/{id}")
    public Place getPlaceById(@PathVariable String id) {
        return mapper.toRest(service.getById(id));
    }

    @GetMapping("/places")
    public List<Place> getPlaces() {
        return service.getAll()
                .stream()
                .map(mapper::toRest)
                .collect(toUnmodifiableList());
    }

    @PutMapping("/places")
    public List<Place> createOrUpdateCourses(@RequestBody List<Place> toWrite) {
        return service
                .saveAll(toWrite
                        .stream()
                        .map(mapper::toDomain)
                        .collect(toUnmodifiableList()))
                .stream()
                .map(mapper::toRest)
                .collect(toUnmodifiableList());
    }
}
