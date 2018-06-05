package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.EventTypeDao;
import com.project.event.server.Domain.Dto.EventTypeDto;
import com.project.event.server.Domain.Report.EventTypeReport;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EventTypeDaoImpl implements EventTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<EventTypeReport> getAllEventTypes() {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" name AS name, ");
        strSelect.append(" active AS active ");
        strSelect.append(" FROM ");
        strSelect.append(" tblEventType ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(EventTypeReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("name", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);

        return query.list();
    }

    @Override
    @Transactional
    public int createEventType(EventTypeDto eventTypeDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO tblEventType ");
        strQuery.append(" (name, active) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:name, :active) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("name", eventTypeDto.getName(), StandardBasicTypes.STRING);
        query.setParameter("active", eventTypeDto.isActive(), StandardBasicTypes.BOOLEAN);

        return query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public EventTypeReport getEventTypeById(Long id) {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" name AS name, ");
        strSelect.append(" active AS active ");
        strSelect.append(" FROM ");
        strSelect.append(" tblEventType ");
        strSelect.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(EventTypeReport.class));
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("name", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);

        return (EventTypeReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public int updateEventType(EventTypeDto eventTypeDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblEventType ");
        strQuery.append(" SET name = :name, ");
        strQuery.append(" active = :active ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("name", eventTypeDto.getName(), StandardBasicTypes.STRING);
        query.setParameter("active", eventTypeDto.isActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("id", eventTypeDto.getId(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteEventType(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblEventType ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
