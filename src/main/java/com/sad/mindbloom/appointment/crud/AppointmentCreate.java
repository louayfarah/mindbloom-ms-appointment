package com.sad.mindbloom.appointment.crud;

import java.time.LocalDateTime;

import com.sad.mindbloom.appointment.model.Appointment;

public class AppointmentCreate {
    private Integer studentId;
    private Integer counselorId;
    private LocalDateTime dateTime;
    private String status;
    private String location;

    public static Appointment to(final AppointmentCreate item) {
        final Appointment res = new Appointment();

        res.setStudentId(item.getStudentId());
        res.setCounselorId(item.getCounselorId());
        res.setDateTime(item.getDateTime());
        res.setStatus(item.getStatus());
        res.setLocation(item.getLocation());
        

        return res;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCounselorId() {
        return counselorId;
    }

    public void setCounselorId(Integer counselorId) {
        this.counselorId = counselorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    

}
