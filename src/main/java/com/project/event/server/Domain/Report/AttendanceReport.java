package com.project.event.server.Domain.Report;

public class AttendanceReport {
    private Long id;
    private boolean attendance;
    private int rate;
    private Long idUser;
    private UserReport userReport;
    private Long idEvent;
    private EventReport eventReport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsAttendance() {
        return attendance;
    }

    public void setIsAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public UserReport getUserReport() {
        return userReport;
    }

    public void setUserReport(UserReport userReport) {
        this.userReport = userReport;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public EventReport getEventReport() {
        return eventReport;
    }

    public void setEventReport(EventReport eventReport) {
        this.eventReport = eventReport;
    }
}
