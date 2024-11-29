package hu.szarvas.resources_service.repository;

import hu.szarvas.resources_service.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehousesRepository extends JpaRepository<Warehouse, Integer> {
    List<Warehouse> findByNameContainingIgnoreCase(String name);
}
