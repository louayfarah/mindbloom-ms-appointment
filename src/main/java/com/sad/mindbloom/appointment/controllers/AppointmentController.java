package com.sad.mindbloom.appointment.controllers;

import io.swagger.v3.oas.annotations.Operation;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sad.mindbloom.appointment.services.AppointmentService;
import com.sad.mindbloom.appointment.crud.AppointmentCreate;
import com.sad.mindbloom.appointment.crud.AppointmentRead;





class NotFound extends RuntimeException {
}


@RestController
@RequestMapping("/api/appointments")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Operation(summary = "List all appointments or filter by student or counselor")
    @GetMapping
    Stream<AppointmentRead> all(@RequestParam(required = false) Integer studentId, 
                                @RequestParam(required = false) Integer counselorId) {
        return appointmentService.list()
            .filter(item -> (studentId == null || item.getStudentId().equals(studentId)) &&
                            (counselorId == null || item.getCounselorId().equals(counselorId)))
            .map(AppointmentRead::from);
    }

    @Operation(summary = "Book a new appointment")
    @PostMapping
    AppointmentRead add(final @RequestBody @Validated AppointmentCreate newAppointment) {
        // Check that the student doesn't have an appointment at the same time
        if (appointmentService.list()
                .anyMatch(item -> item.getStudentId().equals(newAppointment.getStudentId()))) {
            throw new IllegalArgumentException("Student already has an appointment");
        }

        // Return the new appointment
        return appointmentService.add(AppointmentCreate.to(newAppointment))
                .map(item -> AppointmentRead.from(item)).orElseThrow(() -> new NotFound());
    }

    @Operation(summary = "Update the status of an appointment")
    @PatchMapping("/{id}")
    AppointmentRead updateStatus(final @RequestParam Integer id, final @RequestParam String status) {
        return appointmentService.updateAppointmentStatus(id, status)
                .map(item -> AppointmentRead.from(item)).orElseThrow(() -> new NotFound());
    }

}
