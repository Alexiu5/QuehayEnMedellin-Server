package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.EventTypeDto;
import com.project.event.server.Domain.Report.EventTypeReport;

import java.util.List;

public interface EventTypeDao {
    List<EventTypeReport> getAllEventTypes ();
    int createEventType (EventTypeDto eventTypeDto);
    EventTypeReport getEventTypeById (Long id);
    int updateEventType (EventTypeDto eventTypeDto);
    void deleteEventType (Long id);
}
