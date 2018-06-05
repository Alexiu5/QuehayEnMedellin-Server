package com.project.event.server.Dao.Impl;

import com.project.event.server.Dao.UserDao;
import com.project.event.server.Domain.Dto.UserDto;
import com.project.event.server.Domain.Report.UserReport;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public int userLogin (String username, String password) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT EXISTS ( ");
        strQuery.append(" SELECT ");
        strQuery.append(" id ");
        strQuery.append(" FROM ");
        strQuery.append(" tblUser ");
        strQuery.append(" WHERE email = :email");
        strQuery.append(" AND password = :password ");
        strQuery.append(" ) AS exist ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("email", username, StandardBasicTypes.STRING);
        query.setParameter("password", password, StandardBasicTypes.STRING);

        query.addScalar("exist", StandardBasicTypes.INTEGER);

        return (int) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserReport> getAllUsers() {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" firstName AS firstName, ");
        strSelect.append(" lastName AS lastName, ");
        strSelect.append(" login AS login, ");
        strSelect.append(" email AS email, ");
        strSelect.append(" phone AS phone, ");
        strSelect.append(" active AS active, ");
        strSelect.append(" idRole AS idRole, ");
        strSelect.append(" creationDate AS creationDate ");
        strSelect.append(" FROM ");
        strSelect.append(" tblUser ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(UserReport.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("firstName", StandardBasicTypes.STRING);
        query.addScalar("lastName", StandardBasicTypes.STRING);
        query.addScalar("login", StandardBasicTypes.STRING);
        query.addScalar("email", StandardBasicTypes.STRING);
        query.addScalar("phone", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);
        query.addScalar("idRole", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);

        return query.list();
    }

    @Override
    @Transactional
    public int createUser(UserDto userDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO ");
        strQuery.append(" tblUser ");
        strQuery.append(" (firstName, lastName, login, password,  email, phone, active, idRole, creationDate) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:firstName, :lastName, :login, :password, :email, :phone, :active, :idRole, :creationDate) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("firstName", userDto.getFirstName(), StandardBasicTypes.STRING);
        query.setParameter("lastName", userDto.getLastName(), StandardBasicTypes.STRING);
        query.setParameter("login", userDto.getLogin(), StandardBasicTypes.STRING);
        query.setParameter("password", userDto.getPassword(), StandardBasicTypes.STRING);
        query.setParameter("email", userDto.getEmail(), StandardBasicTypes.STRING);
        query.setParameter("phone", userDto.getPhone(), StandardBasicTypes.STRING);
        query.setParameter("active", userDto.isActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("idRole", userDto.getIdRole(), StandardBasicTypes.LONG);
        query.setParameter("creationDate", userDto.getCreationDate(), StandardBasicTypes.DATE);

        return query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public UserReport getUserById(Long userId) {
        StringBuilder strSelect = new StringBuilder();
        strSelect.append(" SELECT ");
        strSelect.append(" id AS id, ");
        strSelect.append(" firstName AS firstName, ");
        strSelect.append(" lastName AS lastName, ");
        strSelect.append(" login AS login, ");
        strSelect.append(" email AS email, ");
        strSelect.append(" phone AS phone, ");
        strSelect.append(" active AS active, ");
        strSelect.append(" idRole AS idRole, ");
        strSelect.append(" creationDate AS creationDate ");
        strSelect.append(" FROM ");
        strSelect.append(" tblUser ");
        strSelect.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strSelect.toString());
        query.setResultTransformer(Transformers.aliasToBean(UserReport.class));

        query.setParameter("id", userId, StandardBasicTypes.LONG);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("firstName", StandardBasicTypes.STRING);
        query.addScalar("lastName", StandardBasicTypes.STRING);
        query.addScalar("login", StandardBasicTypes.STRING);
        query.addScalar("email", StandardBasicTypes.STRING);
        query.addScalar("phone", StandardBasicTypes.STRING);
        query.addScalar("active", StandardBasicTypes.BOOLEAN);
        query.addScalar("idRole", StandardBasicTypes.LONG);
        query.addScalar("creationDate", StandardBasicTypes.DATE);

        return (UserReport) query.uniqueResult();
    }

    @Override
    @Transactional
    public int updateUser(UserDto userDto) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblUser ");
        strQuery.append(" SET ");
        strQuery.append(" firstName = :firstName, ");
        strQuery.append(" lastName = :lastName, ");
        strQuery.append(" login = :login, ");
        strQuery.append(" email = :email, ");
        strQuery.append(" phone = :phone, ");
        strQuery.append(" active = :active ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.setParameter("firstName", userDto.getFirstName(), StandardBasicTypes.STRING);
        query.setParameter("lastName", userDto.getLastName(), StandardBasicTypes.STRING);
        query.setParameter("login", userDto.getLogin(), StandardBasicTypes.STRING);
        query.setParameter("email", userDto.getEmail(), StandardBasicTypes.STRING);
        query.setParameter("phone", userDto.getPhone(), StandardBasicTypes.STRING);
        query.setParameter("active", userDto.isActive(), StandardBasicTypes.BOOLEAN);
        query.setParameter("id", userDto.getId(), StandardBasicTypes.LONG);

        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblUser ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("id", userId, StandardBasicTypes.LONG);

        query.executeUpdate();
    }
}
