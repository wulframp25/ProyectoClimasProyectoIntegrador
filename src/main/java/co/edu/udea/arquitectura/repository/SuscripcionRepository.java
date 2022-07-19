package co.edu.udea.arquitectura.repository;

import co.edu.udea.arquitectura.entity.Estado;
import co.edu.udea.arquitectura.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuscripcionRepository extends JpaRepository <Suscripcion, Long>{
    Optional<Suscripcion> findById(Long id);
}
