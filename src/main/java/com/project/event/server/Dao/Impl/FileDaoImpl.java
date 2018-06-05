package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.FileDao;
import com.project.event.server.Domain.Dto.FileDto;
import com.project.event.server.Domain.Report.FileReport;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FileDaoImpl implements FileDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<FileReport> getAllFiles() {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id AS id, ");
        strQuery.append(" content AS content, ");
        strQuery.append(" url AS url, ");
        strQuery.append(" active AS active, ");
        strQuery.append(" idEvent AS idEvent, ");
        strQuery.append(" creationDate AS creationDate ");
        strQuery.append(" FROM ");
        strQuery.append(" tblFile ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(FileReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("content", StandardBasicTypes.BLOB);
        query.addScalar("url", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);
        query.addScalar("idEvent", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);

        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<FileReport> getFilesByEvent(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id AS id, ");
        strQuery.append(" content AS content, ");
        strQuery.append(" url AS url, ");
        strQuery.append(" active AS active, ");
        strQuery.append(" idEvent AS idEvent, ");
        strQuery.append(" creationDate AS creationDate ");
        strQuery.append(" FROM ");
        strQuery.append(" tblFile ");
        strQuery.append(" WHERE ");
        strQuery.append(" idEvent = :idEvent ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(FileReport.class));

        query.setParameter("idEvent", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("content", StandardBasicTypes.BLOB);
        query.addScalar("url", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);
        query.addScalar("idEvent", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);

        return query.list();
    }

    @Override
    @Transactional
    public int createFile(FileDto fileDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO tblFile ");
        strQuery.append(" (content, url, active, idEvent) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:content, :url, :active, :idEvent) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("content", fileDto.getContent(), StandardBasicTypes.BLOB);
        query.setParameter("url", fileDto.getUrl(), StandardBasicTypes.STRING);
        query.setParameter("active", fileDto.isActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("idEvent", fileDto.getIdEvent(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public FileReport getFileById(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id AS id, ");
        strQuery.append(" content AS content, ");
        strQuery.append(" url AS url, ");
        strQuery.append(" active AS active, ");
        strQuery.append(" idEvent AS idEvent, ");
        strQuery.append(" creationDate AS creationDate ");
        strQuery.append(" FROM ");
        strQuery.append(" tblFile ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(FileReport.class));
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("content", StandardBasicTypes.BLOB);
        query.addScalar("url", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);
        query.addScalar("idEvent", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);

        return (FileReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public void deleteFile(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblFile ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
