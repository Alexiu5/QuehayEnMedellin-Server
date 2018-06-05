package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.EventDto;
import com.project.event.server.Domain.Report.EventReport;

import java.util.List;

public interface EventDao {
    List<EventReport> getAllEvents ();
    int createEvenInt (EventDto eventDto);
    EventReport getEventById (Long id);
    int updateEvent (EventDto eventDto);
    void deleteEvent (Long id);
}
