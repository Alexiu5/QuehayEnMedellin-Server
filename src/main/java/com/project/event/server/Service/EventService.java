package com.project.event.server.Service;

import com.project.event.server.Domain.Dto.EventDto;
import com.project.event.server.Domain.Report.EventReport;

import java.util.List;

public interface EventService {
    List<EventReport> getAllEvents ();
    int createEvenInt (EventDto eventDto);
    EventReport getEventById (Long id);
    int updateEvent (EventDto eventDto);
    void deleteEvent (Long id);
}
