package com.project.event.server.Service.Impl;

import com.project.event.server.Dao.AttendanceDao;
import com.project.event.server.Dao.EventDao;
import com.project.event.server.Dao.UserDao;
import com.project.event.server.Domain.Dto.AttendanceDto;
import com.project.event.server.Domain.Report.AttendanceReport;
import com.project.event.server.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private EventDao eventDao;

    @Override
    public List<AttendanceReport> getAllAttendance() {
        List<AttendanceReport> attendanceReports = new ArrayList<>();
        List<AttendanceReport> attendanceList = new ArrayList<>();
        attendanceReports = attendanceDao.getAllAttendance();

        for (AttendanceReport attendanceReport : attendanceReports) {
            attendanceReport.setUserReport(userDao.getUserById(attendanceReport.getIdUser()));
            attendanceReport.setEventReport(eventDao.getEventById(attendanceReport.getIdEvent()));
            attendanceList.add(attendanceReport);
        }

        return attendanceList;
    }

    @Override
    public List<AttendanceReport> getAllAttendanceByEvent(Long id) {
        List<AttendanceReport> attendanceReports = new ArrayList<>();
        List<AttendanceReport> attendanceList = new ArrayList<>();
        attendanceReports = attendanceDao.getAllAttendanceByEvent(id);

        for (AttendanceReport attendanceReport : attendanceReports) {
            attendanceReport.setUserReport(userDao.getUserById(attendanceReport.getIdUser()));
            attendanceReport.setEventReport(eventDao.getEventById(attendanceReport.getIdEvent()));
            attendanceList.add(attendanceReport);
        }

        return attendanceList;
    }

    @Override
    public int createAttendance(AttendanceDto attendanceDto) {
        return attendanceDao.createAttendance(attendanceDto);
    }

    @Override
    public AttendanceReport getAttendanceById(Long id) {
        return attendanceDao.getAttendanceById(id);
    }

    @Override
    public int updateAttendance(AttendanceDto attendanceDto) {
        return attendanceDao.updateAttendance(attendanceDto);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceDao.deleteAttendance(id);
    }
}
