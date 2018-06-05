package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.RoleDto;
import com.project.event.server.Domain.Report.RoleReport;

import java.util.List;

public interface RoleDao {
    List<RoleReport> getAllRoles ();
    int createRole (RoleDto roleDto);
    RoleReport getRoleById (Long userId);
    int updateRole (RoleDto roleDto);
    void deleteRole (Long roleId);
}
