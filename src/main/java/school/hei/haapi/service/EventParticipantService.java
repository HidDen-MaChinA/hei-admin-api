package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.EventParticipant;
import school.hei.haapi.repository.EventParticipantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EventParticipantService {
    private final EventParticipantRepository repository;

    public List<EventParticipant> getAll() {
        return repository.findAll();
    }

    public EventParticipant getById(String eventParticipantId) {
        return repository.getById(eventParticipantId);
    }

    public List<EventParticipant> saveAll(List<EventParticipant> eventParticipants) {
        return repository.saveAll(eventParticipants);
    }
}
