package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.EventDto;
import com.project.event.server.Domain.Report.EventReport;

import java.util.List;

public interface EventDao {
    List<EventReport> getAllEvents ();
    List<EventReport> getAllEventsByIdUsuario(long idUser);
    int createEvenInt (EventDto eventDto);
    EventReport getEventById (Long id);
    int updateEvent (EventDto eventDto);
    void validateEvent(Long id, Boolean published);
    void deleteEvent (Long id);

}
