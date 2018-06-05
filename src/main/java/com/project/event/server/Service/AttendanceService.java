package com.project.event.server.Service;

import com.project.event.server.Domain.Dto.AttendanceDto;
import com.project.event.server.Domain.Report.AttendanceReport;

import java.util.List;

public interface AttendanceService {
    List<AttendanceReport> getAllAttendance ();
    List<AttendanceReport> getAllAttendanceByEvent (Long id);
    int createAttendance (AttendanceDto attendanceDto);
    AttendanceReport getAttendanceById (Long id);
    int updateAttendance (AttendanceDto attendanceDto);
    void deleteAttendance (Long id);
}
