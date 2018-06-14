package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.UserDto;
import com.project.event.server.Domain.Report.UserReport;

import java.util.List;

public interface UserDao {
    int userLogin (String username, String password);
    List<UserReport> getAllUsers ();
    int createUser (UserDto userDto);
    UserReport getUserById (Long userId);
    UserReport getUserIdByEmail(String email);
    int updateUser (UserDto userDto);
    void disableUser(Long userId, Boolean value);
    void deleteUser (Long userId);
}
