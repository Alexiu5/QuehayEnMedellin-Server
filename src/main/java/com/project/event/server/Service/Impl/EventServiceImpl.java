package com.project.event.server.Service.Impl;

import com.project.event.server.Dao.EventDao;
import com.project.event.server.Dao.EventTypeDao;
import com.project.event.server.Dao.TagDao;
import com.project.event.server.Dao.UserDao;
import com.project.event.server.Domain.Dto.EventDto;
import com.project.event.server.Domain.Report.EventReport;
import com.project.event.server.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private EventTypeDao eventTypeDao;

    @Autowired
    private TagDao tagDao;

    @Override
    public List<EventReport> getAllEvents() {
        List<EventReport> eventReports = new ArrayList<>();
        List<EventReport> eventList = new ArrayList<>();
        eventReports= eventDao.getAllEvents();

        for (EventReport eventReport : eventReports) {
            eventReport.setUser(userDao.getUserById(eventReport.getUserId()));
            eventReport.setEventType(eventTypeDao.getEventTypeById(eventReport.getEventTypeId()));
            eventList.add(eventReport);
        }

        return eventList;
    }

    @Override
    public int createEvenInt(EventDto eventDto) {
        int eventId = eventDao.createEvenInt(eventDto);

        if (eventDto.getTagIds() != null && eventDto.getTagIds().size() > 0) {
            tagDao.createTagEvent(eventId, eventDto.getTagIds());
        }

        return 1;
    }

    @Override
    public EventReport getEventById(Long id) {
        return eventDao.getEventById(id);
    }

    @Override
    public int updateEvent(EventDto eventDto) {
        return eventDao.updateEvent(eventDto);
    }

    @Override
    public void deleteEvent(Long id) {
        eventDao.deleteEvent(id);
    }
}
