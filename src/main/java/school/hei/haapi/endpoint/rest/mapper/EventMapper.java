package school.hei.haapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Event;

@Component
@AllArgsConstructor
public class EventMapper {

    public Event toRest(school.hei.haapi.model.Event domainEvent) {
        return new Event()
                .idEvent(domainEvent.getId())
                .title(domainEvent.getTitle())
                .type(Event.TypeEnum.valueOf(domainEvent.getType().toString()))
                .place(domainEvent.getPlace())
                .eventStart(domainEvent.getEventStart())
                .eventEnd(domainEvent.getEventEnd())
                .eventResponsible(domainEvent.getEventResponsible())
                .canceled(domainEvent.isCanceled());
    }

    public school.hei.haapi.model.Event toDomain(Event restEvent) {
        return school.hei.haapi.model.Event.builder()
                .id(restEvent.getIdEvent())
                .title(restEvent.getTitle())
                .type(school.hei.haapi.model.Event.Type.valueOf(restEvent.getType().toString()))
                .place(restEvent.getPlace())
                .eventStart(restEvent.getEventStart())
                .eventEnd(restEvent.getEventEnd())
                .canceled(restEvent.getCanceled())
                .build();
    }
}
