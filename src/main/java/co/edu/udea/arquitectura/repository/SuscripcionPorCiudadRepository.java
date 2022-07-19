package co.edu.udea.arquitectura.repository;

import co.edu.udea.arquitectura.entity.SuscripcionPorCiudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SuscripcionPorCiudadRepository extends JpaRepository<SuscripcionPorCiudad, Long> {
    Optional<SuscripcionPorCiudad> findById(Long id);

    @Query("SELECT susPorCiu FROM SuscripcionPorCiudad susPorCiu JOIN susPorCiu.suscripcion subs JOIN subs.usuario us" +
            " WHERE us.id = :idUsuario ")
    List<SuscripcionPorCiudad> buscarPorCodigoUsuario(@Param("idUsuario") Long idUsuario);

    void deleteByFkCiudadAndFkSuscripcion(Long fkCiudad, Long fkSuscripcion);

    void deleteByFkSuscripcion(Long fkSuscripcion);

    List<SuscripcionPorCiudad> findByFkSuscripcion(Long fkSuscripcion);
}
