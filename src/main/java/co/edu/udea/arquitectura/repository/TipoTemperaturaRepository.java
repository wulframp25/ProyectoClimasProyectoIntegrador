package co.edu.udea.arquitectura.repository;

import co.edu.udea.arquitectura.entity.TipoTemperatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoTemperaturaRepository extends JpaRepository<TipoTemperatura, Long>{
    Optional<TipoTemperatura> findByNombre(String nombre);
}
