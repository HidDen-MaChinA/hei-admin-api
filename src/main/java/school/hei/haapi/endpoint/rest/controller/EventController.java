package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.EventMapper;
import school.hei.haapi.endpoint.rest.model.Event;
import school.hei.haapi.service.EventService;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
@AllArgsConstructor
public class EventController {

    private final EventService service;
    private final EventMapper mapper;

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable String id) {
        return mapper.toRest(service.getById(id));
    }

    @DeleteMapping("/events/id")
    public void deleteEventById(@PathVariable String id) {
        service.deleteById(id);
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return service.getAll()
                .stream()
                .map(mapper::toRest)
                .collect(toUnmodifiableList());
    }

    @PutMapping("/events")
    public List<Event> createOrUpdateEvents(@RequestBody List<Event> toWrite) {
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
