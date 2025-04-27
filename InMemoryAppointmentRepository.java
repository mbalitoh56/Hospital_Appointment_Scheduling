package repositories.inmemory;

import hospitalappointmentsystem.Appointment;
import repositories.AppointmentRepository;

import java.util.*;

/**
 * In-memory implementation of AppointmentRepository.
 */
public class InMemoryAppointmentRepository implements AppointmentRepository {
    private final Map<String, Appointment> storage = new HashMap<>();

    @Override
    public void save(Appointment appointment) {
        String key = generateKey(appointment);
        storage.put(key, appointment);
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Appointment> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    private String generateKey(Appointment appointment) {
        // Unique key based on doctor, date, and time
        return appointment.doctorName + "_" + appointment.date + "_" + appointment.time;
    }
}
