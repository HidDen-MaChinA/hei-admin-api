package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.EventParticipantMapper;
import school.hei.haapi.endpoint.rest.model.EventParticipant;
import school.hei.haapi.service.EventParticipantService;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
@AllArgsConstructor
public class EventParticipantController {

    private final EventParticipantService service;
    private final EventParticipantMapper mapper;

    @GetMapping("/event/participants/{id}")
    public EventParticipant getEventParticipantById(@PathVariable String id) {
        return mapper.toRest(service.getById(id));
    }

    @GetMapping("/event/participants")
    public List<EventParticipant> getEventParticipants() {
        return service.getAll()
                .stream()
                .map(mapper::toRest)
                .collect(toUnmodifiableList());
    }

    @PutMapping("/event/participants")
    public List<EventParticipant> createOrUpdateEventParticipant(@RequestBody List<EventParticipant> toWrite) {
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
