package co.edu.udea.arquitectura.service;

import co.edu.udea.arquitectura.entity.SuscripcionPorCiudad;
import co.edu.udea.arquitectura.exception.BusinessException;
import co.edu.udea.arquitectura.repository.SuscripcionPorCiudadRepository;
import co.edu.udea.arquitectura.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class SuscripcionPorCiudadService {
    private final SuscripcionPorCiudadRepository suscripcionPorCiudadRepository;
    private final Messages messages;

    public SuscripcionPorCiudadService(SuscripcionPorCiudadRepository suscripcionPorCiudadRepository, Messages messages) {
        this.suscripcionPorCiudadRepository = suscripcionPorCiudadRepository;
        this.messages = messages;
    }

    public SuscripcionPorCiudad guardarSuscripcion(SuscripcionPorCiudad suscripcionPorCiudad) {
        return suscripcionPorCiudadRepository.save(suscripcionPorCiudad);
    }

    public SuscripcionPorCiudad actualizarSuscripcionPorCiudad(SuscripcionPorCiudad suscripcionPorCiudad) {
        if (Objects.isNull(suscripcionPorCiudad.getId())) {
            throw new BusinessException(messages.get("suscripcion.id.vacio"));
        }
        consultarPorId(suscripcionPorCiudad.getId());
        return suscripcionPorCiudadRepository.save(suscripcionPorCiudad);
    }

    public SuscripcionPorCiudad consultarPorId(Long id) {
        return suscripcionPorCiudadRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("estado.id.no_encontrado")));
    }

    public void eliminarSuscripcion(Long id, Long idCiudad) {
        suscripcionPorCiudadRepository.deleteByFkCiudadAndFkSuscripcion(idCiudad, id);
    }

    public List<SuscripcionPorCiudad> buscarPorCodigoUsuario(Long idUsuario) {
        return suscripcionPorCiudadRepository.buscarPorCodigoUsuario(idUsuario);
    }

    public void deleteByFkSuscripcion(Long fkSuscripcion) {
        suscripcionPorCiudadRepository.deleteByFkSuscripcion(fkSuscripcion);
    }

    public List<SuscripcionPorCiudad> findByFkSuscripcion(Long subscriptionId) {
        return suscripcionPorCiudadRepository.findByFkSuscripcion(subscriptionId);
    }
}
