package repositories.database;

import models.Appointment;
import repositories.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class DatabaseAppointmentRepository implements AppointmentRepository {

    @Override
    public void save(Appointment entity) {
        // TODO: Implement saving to database (e.g., SQL INSERT)
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }

    @Override
    public Optional<Appointment> findById(String id) {
        // TODO: Implement finding by ID from database (e.g., SQL SELECT)
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }

    @Override
    public List<Appointment> findAll() {
        // TODO: Implement fetching all appointments from database
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }

    @Override
    public void delete(String id) {
        // TODO: Implement deleting from database
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }
}
