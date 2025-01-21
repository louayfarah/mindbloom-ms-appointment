package com.sad.mindbloom.appointment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sad.mindbloom.appointment.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}