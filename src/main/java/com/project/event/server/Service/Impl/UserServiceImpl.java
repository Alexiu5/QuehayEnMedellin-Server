package com.project.event.server.Service.Impl;

import com.project.event.server.Dao.UserDao;
import com.project.event.server.Domain.Dto.UserDto;
import com.project.event.server.Domain.Report.UserReport;
import com.project.event.server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int userLogin (String username, String password) {
        return userDao.userLogin (username, password);
    }

    @Override
    public List<UserReport> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public int createUser(UserDto userDto) {
        userDto.setCreationDate(new Date());
        return userDao.createUser(userDto);
    }

    @Override
    public UserReport getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public int updateUser(UserDto userDto) {
        return userDao.updateUser(userDto);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }
}
