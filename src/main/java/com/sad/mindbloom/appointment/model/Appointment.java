package com.sad.mindbloom.appointment.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "appointment")
@EqualsAndHashCode(callSuper = true)
public final class Appointment extends Base {
    
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "counselor_id")
    private Integer counselorId;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "status")
    private String status;
    @Column(name = "location")
    private String location;
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