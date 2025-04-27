package factories;

import repositories.AppointmentRepository;
import repositories.inmemory.InMemoryAppointmentRepository;

public class RepositoryFactory {

    public static AppointmentRepository getAppointmentRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryAppointmentRepository();
            // case "DATABASE":
            //     return new DatabaseAppointmentRepository(); // Future implementation
            default:
                throw new IllegalArgumentException("Invalid storage type: " + storageType);
        }
    }
}
