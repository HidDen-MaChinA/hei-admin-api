package school.hei.haapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.EventParticipant;

@Component
@AllArgsConstructor
public class EventParticipantMapper {

    public EventParticipant toRest(school.hei.haapi.model.EventParticipant domainEventParticipant) {
        return new EventParticipant()
                .id(domainEventParticipant.getId())
                .event(domainEventParticipant.getEvent())
                .participant(domainEventParticipant.getParticipant())
                .participantStatus(EventParticipant
                        .ParticipantStatusEnum
                        .valueOf(domainEventParticipant
                                .getParticipantStatus()
                                .toString()
                        )
                );
    }

    public school.hei.haapi.model.EventParticipant toDomain(EventParticipant restEventParticipant) {
        return school.hei.haapi.model.EventParticipant.builder()
                .id(restEventParticipant.getId())
                .event(restEventParticipant.getEvent())
                .participant(restEventParticipant.getParticipant())
                .participantStatus(school.hei.haapi.model.EventParticipant
                        .ParticipantStatus.
                        valueOf(restEventParticipant
                                .getParticipantStatus()
                                .toString()
                        )
                ).build();
    }
}
