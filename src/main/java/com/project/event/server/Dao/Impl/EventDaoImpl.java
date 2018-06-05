package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.EventDao;
import com.project.event.server.Domain.Dto.EventDto;
import com.project.event.server.Domain.Report.EventReport;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<EventReport> getAllEvents() {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" title AS title, ");
        strSelect.append(" description AS description, ");
        strSelect.append(" longitude AS longitude, ");
        strSelect.append(" latitude AS latitude, ");
        strSelect.append(" date AS date, ");
        strSelect.append(" address AS address, ");
        strSelect.append(" active AS active, ");
        strSelect.append(" cost AS cost, ");
        strSelect.append(" creationDate AS creationDate, ");
        strSelect.append(" updateDate AS updateDate, ");
        strSelect.append(" idUser AS userId, ");
        strSelect.append(" idEventType as eventTypeId, ");
        strSelect.append(" published AS publishedActive, ");
        strSelect.append(" publishedDate AS publishedDate ");
        strSelect.append(" FROM ");
        strSelect.append(" tblEvent ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(EventReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("title", StandardBasicTypes.STRING);
        query.addScalar("description", StandardBasicTypes.STRING);
        query.addScalar("longitude", StandardBasicTypes.STRING);
        query.addScalar("latitude", StandardBasicTypes.STRING);
        query.addScalar("date", StandardBasicTypes.DATE);
        query.addScalar("address", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);
        query.addScalar("cost", StandardBasicTypes.DOUBLE);
        query.addScalar("creationDate", StandardBasicTypes.DATE);
        query.addScalar("updateDate", StandardBasicTypes.DATE);
        query.addScalar("userId", StandardBasicTypes.LONG);
        query.addScalar("eventTypeId", StandardBasicTypes.LONG);
        query.addScalar("publishedActive", StandardBasicTypes.BOOLEAN);
        query.addScalar("publishedDate", StandardBasicTypes.DATE);

        return query.list();
    }

    @Override
    @Transactional
    public int createEvenInt(EventDto eventDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO tblEvent ");
        strQuery.append(" (title, description, longitude, latitude, date, address, active, cost, idUser, idEventType, published, publishedDate) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:title, :description, :longitude, :latitude, :date, :address, :active, :cost, :userId, :eventTypeId, :published, :publishedDate) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("title", eventDto.getTitle(), StandardBasicTypes.STRING);
        query.setParameter("description", eventDto.getDescription(), StandardBasicTypes.STRING);
        query.setParameter("longitude", eventDto.getLongitude(), StandardBasicTypes.STRING);
        query.setParameter("latitude", eventDto.getLatitude(), StandardBasicTypes.STRING);
        query.setParameter("date", eventDto.getDate(), StandardBasicTypes.DATE);
        query.setParameter("address", eventDto.getAddress(), StandardBasicTypes.STRING);
        query.setParameter("active", eventDto.isActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("cost", eventDto.getCost(), StandardBasicTypes.DOUBLE);
        query.setParameter("userId", eventDto.getIdUser(), StandardBasicTypes.LONG);
        query.setParameter("eventTypeId", eventDto.getIdEventType(), StandardBasicTypes.LONG);
        query.setParameter("published", eventDto.isPublishedActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("publishedDate", eventDto.getPublishedDate(), StandardBasicTypes.DATE);

        query.executeUpdate();

        NativeQuery queryLastInsert = sessionFactory.getCurrentSession().createNativeQuery(" SELECT LAST_INSERT_ID() AS eventId ");
        queryLastInsert.addScalar("eventId", StandardBasicTypes.INTEGER);

        int eventCreatedId = (int) queryLastInsert.uniqueResult();

        return eventCreatedId;
    }

    @Override
    @Transactional(readOnly = true)
    public EventReport getEventById(Long id) {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" title AS title, ");
        strSelect.append(" description AS description, ");
        strSelect.append(" longitude AS longitude, ");
        strSelect.append(" latitude AS latitude, ");
        strSelect.append(" date AS date, ");
        strSelect.append(" address AS address, ");
        strSelect.append(" active AS active, ");
        strSelect.append(" cost AS cost, ");
        strSelect.append(" creationDate AS creationDate, ");
        strSelect.append(" updateDate AS updateDate, ");
        strSelect.append(" idUser AS userId, ");
        strSelect.append(" idEventType as eventTypeId, ");
        strSelect.append(" published AS publishedActive, ");
        strSelect.append(" publishedDate AS publishedDate ");
        strSelect.append(" FROM ");
        strSelect.append(" tblEvent ");
        strSelect.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(EventReport.class));

        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("title", StandardBasicTypes.STRING);
        query.addScalar("description", StandardBasicTypes.STRING);
        query.addScalar("longitude", StandardBasicTypes.STRING);
        query.addScalar("latitude", StandardBasicTypes.STRING);
        query.addScalar("date", StandardBasicTypes.DATE);
        query.addScalar("address", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);
        query.addScalar("cost", StandardBasicTypes.DOUBLE);
        query.addScalar("creationDate", StandardBasicTypes.DATE);
        query.addScalar("updateDate", StandardBasicTypes.DATE);
        query.addScalar("userId", StandardBasicTypes.LONG);
        query.addScalar("eventTypeId", StandardBasicTypes.LONG);
        query.addScalar("publishedActive", StandardBasicTypes.BOOLEAN);
        query.addScalar("publishedDate", StandardBasicTypes.DATE);

        return (EventReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public int updateEvent(EventDto eventDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblEvent ");
        strQuery.append(" SET title = :title, ");
        strQuery.append(" description = :description, ");
        strQuery.append(" longitude = :longitude, ");
        strQuery.append(" latitude = :latitude, ");
        strQuery.append(" date = :date, ");
        strQuery.append(" address = :address, ");
        strQuery.append(" active = :active, ");
        strQuery.append(" cost = :cost, ");
        strQuery.append(" idEventType = :eventTypeId ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", eventDto.getId(), StandardBasicTypes.LONG);
        query.setParameter("title", eventDto.getTitle(), StandardBasicTypes.STRING);
        query.setParameter("description", eventDto.getDescription(), StandardBasicTypes.STRING);
        query.setParameter("longitude", eventDto.getLongitude(), StandardBasicTypes.STRING);
        query.setParameter("latitude", eventDto.getLatitude(), StandardBasicTypes.STRING);
        query.setParameter("date", eventDto.getDate(), StandardBasicTypes.DATE);
        query.setParameter("address", eventDto.getAddress(), StandardBasicTypes.STRING);
        query.setParameter("active", eventDto.isActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("cost", eventDto.getCost(), StandardBasicTypes.DOUBLE);
        query.setParameter("eventTypeId", eventDto.getIdEventType(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteEvent(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblEvent ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
