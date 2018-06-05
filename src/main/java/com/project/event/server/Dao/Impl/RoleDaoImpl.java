package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.RoleDao;
import com.project.event.server.Domain.Dto.RoleDto;
import com.project.event.server.Domain.Report.RoleReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<RoleReport> getAllRoles() {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" name AS name, ");
        strSelect.append(" active AS active ");
        strSelect.append(" FROM ");
        strSelect.append(" tblRole ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(RoleReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("name", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);

        return query.list();
    }

    @Override
    @Transactional
    public int createRole(RoleDto roleDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO tblRole ");
        strQuery.append(" (name, active) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:name, :active) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("name", roleDto.getName(), StandardBasicTypes.STRING);
        query.setParameter("active", roleDto.isActive(), StandardBasicTypes.BOOLEAN);

        return query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public RoleReport getRoleById(Long userId) {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" name AS name, ");
        strSelect.append(" active AS active ");
        strSelect.append(" FROM ");
        strSelect.append(" tblRole ");
        strSelect.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(RoleReport.class));
        query.setParameter("id", userId, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("name", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);

        return (RoleReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public int updateRole(RoleDto roleDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblRole ");
        strQuery.append(" SET name = :name, ");
        strQuery.append(" active = :active ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("name", roleDto.getName(), StandardBasicTypes.STRING);
        query.setParameter("active", roleDto.isActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("id", roleDto.getId(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteRole(Long roleId) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblRole ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", roleId, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
