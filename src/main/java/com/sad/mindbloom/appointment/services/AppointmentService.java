package com.sad.mindbloom.appointment.services;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.sad.mindbloom.appointment.model.Appointment;
import com.sad.mindbloom.appointment.repositories.AppointmentRepository;




@Component
@RequiredArgsConstructor
public final class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public Optional<Appointment> findById(final Integer id) {
        return id == null ? Optional.empty() : appointmentRepository.findById(id);
    }

    public Stream<Appointment> list() {
        return appointmentRepository.findAll().stream();
    }

    public Optional<Appointment> add(final Appointment appointment) {
        return Optional.of(appointmentRepository.save(appointment));
    }

    public Optional<Appointment> updateAppointmentStatus(final Integer id, final String status) {
        return appointmentRepository.findById(id)
            .map(appointment -> {
                appointment.setStatus(status);
                return appointmentRepository.save(appointment);
            });
    }
}