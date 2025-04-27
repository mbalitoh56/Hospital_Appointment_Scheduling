package repositories;

import java.util.List;
import java.util.Optional;

/**
 * A generic Repository interface for basic CRUD operations.
 * 
 * @param <T> Entity type
 * @param <ID> ID type
 */
public interface Repository<T, ID> {
    void save(T entity);              // Create/Update
    Optional<T> findById(ID id);       // Read (Single)
    List<T> findAll();                 // Read (All)
    void delete(ID id);                // Delete
}

