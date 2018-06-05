package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.UserDto;
import com.project.event.server.Domain.Report.UserReport;

import java.util.List;

public interface UserDao {
    int userLogin (String username, String password);
    List<UserReport> getAllUsers ();
    int createUser (UserDto userDto);
    UserReport getUserById (Long userId);
    int updateUser (UserDto userDto);
    void deleteUser (Long userId);
}
