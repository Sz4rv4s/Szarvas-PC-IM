package hu.szarvas.resources_service.repository;

import hu.szarvas.resources_service.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartsRepository extends JpaRepository<Part, Integer> {
    List<Part> findByModelContainingIgnoreCase(final String name);
}
