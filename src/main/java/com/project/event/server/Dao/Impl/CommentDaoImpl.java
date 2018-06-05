package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.CommentDao;
import com.project.event.server.Domain.Dto.CommentDto;
import com.project.event.server.Domain.Report.CommentReport;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<CommentReport> getAllComments() {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" comment AS comment, ");
        strSelect.append(" idEvent AS idEvent, ");
        strSelect.append(" idUser AS idUser, ");
        strSelect.append(" creationDate AS creationDate, ");
        strSelect.append(" updateDate AS updateDate ");
        strSelect.append(" FROM ");
        strSelect.append(" tblComment ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(CommentReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("comment", StandardBasicTypes.TEXT);
        query.addScalar("idEvent", StandardBasicTypes.LONG);
        query.addScalar("idUser", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);
        query.addScalar("updateDate", StandardBasicTypes.DATE);

        return query.list();

    }
    @Override
    @Transactional(readOnly = true)
    public List<CommentReport> getCommentsByEvent (Long eventId) {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" comment AS comment, ");
        strSelect.append(" idEvent AS idEvent, ");
        strSelect.append(" idUser AS idUser, ");
        strSelect.append(" creationDate AS creationDate, ");
        strSelect.append(" updateDate AS updateDate ");
        strSelect.append(" FROM ");
        strSelect.append(" tblComment ");
        strSelect.append(" WHERE idEvent = :idEvent ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(CommentReport.class));

        query.setParameter("idEvent", eventId, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("comment", StandardBasicTypes.TEXT);
        query.addScalar("idEvent", StandardBasicTypes.LONG);
        query.addScalar("idUser", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);
        query.addScalar("updateDate", StandardBasicTypes.DATE);

        return query.list();
    }

    @Override
    @Transactional
    public int createComment(CommentDto commentDto) {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" INSERT INTO tblComment ");
        strSelect.append(" (comment, idEvent, idUser) ");
        strSelect.append(" VALUES (:comment, :idEvent, :idUser) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());

        query.setParameter("comment", commentDto.getComment(), StandardBasicTypes.TEXT);
        query.setParameter("idEvent", commentDto.getIdEvent(), StandardBasicTypes.LONG);
        query.setParameter("idUser", commentDto.getIdUser(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public CommentReport getCommentById(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id AS id, ");
        strQuery.append(" comment AS comment, ");
        strQuery.append(" idEvent AS idEvent, ");
        strQuery.append(" idUser AS idUser, ");
        strQuery.append(" creationDate AS creationDate, ");
        strQuery.append(" updateDate AS updateDate ");
        strQuery.append(" FROM ");
        strQuery.append(" tblComment ");
        strQuery.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(CommentReport.class));

        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("comment", StandardBasicTypes.TEXT);
        query.addScalar("idEvent", StandardBasicTypes.LONG);
        query.addScalar("idUser", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);
        query.addScalar("updateDate", StandardBasicTypes.DATE);

        return (CommentReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public int updateComment(CommentDto commentDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblComment ");
        strQuery.append(" SET comment = :comment, ");
        strQuery.append(" idEvent = :idEvent, ");
        strQuery.append(" idUser = :idUser ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("comment", commentDto.getComment(), StandardBasicTypes.TEXT);
        query.setParameter("idEvent", commentDto.getIdEvent(), StandardBasicTypes.LONG);
        query.setParameter("idUser", commentDto.getIdUser(), StandardBasicTypes.LONG);
        query.setParameter("id", commentDto.getId(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblComment ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
