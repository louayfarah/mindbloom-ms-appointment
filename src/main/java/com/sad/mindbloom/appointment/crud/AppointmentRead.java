package com.sad.mindbloom.appointment.crud;

import java.time.LocalDateTime;

import com.sad.mindbloom.appointment.model.Appointment;

public class AppointmentRead {
    private Integer id;
    private Integer studentId;
    private Integer counselorId;
    private LocalDateTime dateTime;
    private String status;
    private String location;




    public static AppointmentRead from(final Appointment item) {
        final AppointmentRead appointment = new AppointmentRead();
        appointment.setId(item.getId());
        appointment.setStudentId(item.getStudentId());
        appointment.setCounselorId(item.getCounselorId());
        appointment.setDateTime(item.getDateTime());
        appointment.setStatus(item.getStatus());
        appointment.setLocation(item.getLocation());

        return appointment;
    }




    public Integer getId() {
        return id;
    }




    public void setId(Integer id) {
        this.id = id;
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
