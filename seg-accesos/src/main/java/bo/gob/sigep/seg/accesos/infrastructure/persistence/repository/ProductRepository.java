package bo.gob.sigep.seg.accesos.infrastructure.persistence.repository;

import bo.gob.sigep.seg.accesos.infrastructure.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, CustomProductRepository {
    // Aquí sigues teniendo todos los métodos de JpaRepository disponibles
}