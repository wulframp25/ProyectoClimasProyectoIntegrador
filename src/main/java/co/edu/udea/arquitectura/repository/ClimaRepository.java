package co.edu.udea.arquitectura.repository;

import co.edu.udea.arquitectura.entity.Clima;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClimaRepository extends JpaRepository<Clima, Long> {
    Optional<Clima> findById(Long id);

}
