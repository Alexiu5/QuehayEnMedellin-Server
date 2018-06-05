package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.TagDao;
import com.project.event.server.Domain.Dto.TagDto;
import com.project.event.server.Domain.Report.TagReport;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<TagReport> getAllTags() {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" name AS name ");
        strSelect.append(" FROM ");
        strSelect.append(" tblTag ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(TagReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("name", StandardBasicTypes.STRING);

        return query.list();
    }

    @Override
    @Transactional
    public int createTag(TagDto tagDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO tblTag ");
        strQuery.append(" (name) ");
        strQuery.append(" VALUES (:name) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("name", tagDto.getName(), StandardBasicTypes.STRING);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public int createTagEvent(int eventId, List<Long> tagList) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO tblTagEvent (idEvent, idTag) VALUES ");
        for (Long tagId : tagList) {
            strQuery.append(" (" + eventId + ", " + tagId + " ),");
        }
        strQuery.setLength(strQuery.length() - 1);
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        return query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public TagReport getTagById(Long id) {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" name AS name ");
        strSelect.append(" FROM ");
        strSelect.append(" tblTag ");
        strSelect.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(TagReport.class));
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("name", StandardBasicTypes.STRING);

        return (TagReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public int updateTag(TagDto tagDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblTag ");
        strQuery.append(" SET name = :name ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery updateQuery = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        updateQuery.setParameter("name", tagDto.getName(), StandardBasicTypes.STRING);
        updateQuery.setParameter("id", tagDto.getId(), StandardBasicTypes.LONG);

        return updateQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblTag ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
