package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.Event;
import school.hei.haapi.repository.EventRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository repository;

    public List<Event> getAll() {
        return repository.findAll();
    }

    public Event getById(String eventId) {
        return repository.getById(eventId);
    }

    public List<Event> saveAll(List<Event> events) {
        return repository.saveAll(events);
    }

    public void deleteById(String eventId) {
        repository.deleteById(eventId);
    }
}
