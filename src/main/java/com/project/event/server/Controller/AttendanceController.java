package com.project.event.server.Controller;

import com.project.event.server.Domain.Dto.AttendanceDto;
import com.project.event.server.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/attendance.list")
    @ResponseBody
    public ResponseEntity getAllAttendance (HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("attendances", attendanceService.getAllAttendance());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/attendance.list.{id}")
    @ResponseBody
    public ResponseEntity getAttendanceByEvent (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("attendances", attendanceService.getAllAttendanceByEvent(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/attendance.create")
    @ResponseBody
    public ResponseEntity createAttendance (@RequestBody @Valid AttendanceDto attendanceDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", attendanceService.createAttendance(attendanceDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/attendance.update")
    @ResponseBody
    public ResponseEntity updateAttendance (@RequestBody @Valid AttendanceDto attendanceDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", attendanceService.updateAttendance(attendanceDto));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/attendance.{id}")
    @ResponseBody
    public ResponseEntity getAttendanceByID (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("attendance", attendanceService.getAttendanceById(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/remove.attendance.{id}")
    @ResponseBody
    public ResponseEntity removeAttendance (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        attendanceService.deleteAttendance(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
