package repositories.inmemory;

import hospitalappointmentsystem.Appointment;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryAppointmentRepositoryTest {

    @Test
    void testCRUDOperations() {
        InMemoryAppointmentRepository repo = new InMemoryAppointmentRepository();

        // Create and Save
        Appointment appointment = new Appointment("John Doe", "Dr. Smith", "2025-05-01", "10:00", "Check-up");
        repo.save(appointment);

        // Read - findById
        String id = "Dr. Smith_2025-05-01_10:00";
        Optional<Appointment> found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().patientName);

        // Read - findAll
        List<Appointment> all = repo.findAll();
        assertEquals(1, all.size());

        // Delete
        repo.delete(id);
        Optional<Appointment> afterDelete = repo.findById(id);
        assertFalse(afterDelete.isPresent());
    }
}
