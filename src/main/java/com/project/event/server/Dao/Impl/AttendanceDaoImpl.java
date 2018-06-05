package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.AttendanceDao;
import com.project.event.server.Domain.Dto.AttendanceDto;
import com.project.event.server.Domain.Report.AttendanceReport;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<AttendanceReport> getAllAttendance() {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id AS id, ");
        strQuery.append(" attendance AS attendance, ");
        strQuery.append(" rate AS rate, ");
        strQuery.append(" idUser AS idUser, ");
        strQuery.append(" idEvent AS idEvent ");
        strQuery.append(" FROM ");
        strQuery.append(" tblAttendance ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(AttendanceReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("attendance", StandardBasicTypes.BOOLEAN);
        query.addScalar("rate", StandardBasicTypes.INTEGER);
        query.addScalar("idUser", StandardBasicTypes.LONG);
        query.addScalar("idEvent", StandardBasicTypes.LONG);

        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AttendanceReport> getAllAttendanceByEvent(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id AS id, ");
        strQuery.append(" attendance AS attendance, ");
        strQuery.append(" rate AS rate, ");
        strQuery.append(" idUser AS idUser, ");
        strQuery.append(" idEvent AS idEvent ");
        strQuery.append(" FROM ");
        strQuery.append(" tblAttendance ");
        strQuery.append(" WHERE idEvent = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(AttendanceReport.class));
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("attendance", StandardBasicTypes.BOOLEAN);
        query.addScalar("rate", StandardBasicTypes.INTEGER);
        query.addScalar("idUser", StandardBasicTypes.LONG);
        query.addScalar("idEvent", StandardBasicTypes.LONG);

        return query.list();
    }

    @Override
    @Transactional
    public int createAttendance(AttendanceDto attendanceDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO tblAttendance ");
        strQuery.append(" (attendance, rate, idUser, idEvent) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:attendance, :rate, :idUser, :idEvent) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("attendance", attendanceDto.isAttendance(), StandardBasicTypes.BOOLEAN);
        query.setParameter("rate", attendanceDto.getRate(), StandardBasicTypes.INTEGER);
        query.setParameter("idUser", attendanceDto.getIdUser(), StandardBasicTypes.LONG);
        query.setParameter("idEvent", attendanceDto.getIdEvent(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public AttendanceReport getAttendanceById(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id AS id, ");
        strQuery.append(" attendance AS attendance, ");
        strQuery.append(" rate AS rate, ");
        strQuery.append(" idUser AS idUser, ");
        strQuery.append(" idEvent AS idEvent ");
        strQuery.append(" FROM ");
        strQuery.append(" tblAttendance ");
        strQuery.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(AttendanceReport.class));
        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("attendance", StandardBasicTypes.BOOLEAN);
        query.addScalar("rate", StandardBasicTypes.INTEGER);
        query.addScalar("idUser", StandardBasicTypes.LONG);
        query.addScalar("idEvent", StandardBasicTypes.LONG);

        return (AttendanceReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public int updateAttendance(AttendanceDto attendanceDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblAttendance ");
        strQuery.append(" SET attendance = :attendance, ");
        strQuery.append(" rate = :rate, ");
        strQuery.append(" idUser = :idUser, ");
        strQuery.append(" idEvent = :idEvent ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("id", attendanceDto.getId(),StandardBasicTypes.LONG);
        query.setParameter("attendance", attendanceDto.isAttendance(), StandardBasicTypes.BOOLEAN);
        query.setParameter("rate", attendanceDto.getRate(), StandardBasicTypes.INTEGER);
        query.setParameter("idUser", attendanceDto.getIdUser(), StandardBasicTypes.LONG);
        query.setParameter("idEvent", attendanceDto.getIdEvent(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAttendance(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblAttendance ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("id", id, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
