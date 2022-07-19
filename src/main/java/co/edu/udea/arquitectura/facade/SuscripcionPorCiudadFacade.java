package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.mapper.SuscripcionPorCiudadMapper;
import co.edu.udea.arquitectura.modelo.PaisDTO;
import co.edu.udea.arquitectura.modelo.SuscripcionPorCiudadDTO;
import co.edu.udea.arquitectura.service.SuscripcionPorCiudadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SuscripcionPorCiudadFacade {

    private final SuscripcionPorCiudadService suscripcionPorCiudadService;
    private final SuscripcionPorCiudadMapper suscripcionPorCiudadMapper;

    public SuscripcionPorCiudadFacade(SuscripcionPorCiudadService suscripcionPorCiudadService, SuscripcionPorCiudadMapper suscripcionPorCiudadMapper) {
        this.suscripcionPorCiudadService = suscripcionPorCiudadService;
        this.suscripcionPorCiudadMapper = suscripcionPorCiudadMapper;
    }

    public SuscripcionPorCiudadDTO guardarSuscripcion(SuscripcionPorCiudadDTO suscripcion) {
        return suscripcionPorCiudadMapper.toDto(suscripcionPorCiudadService.guardarSuscripcion(suscripcionPorCiudadMapper.toEntity(suscripcion)));
    }

    public SuscripcionPorCiudadDTO actualizarSuscripcion(SuscripcionPorCiudadDTO suscripcion) {
        return suscripcionPorCiudadMapper.toDto(suscripcionPorCiudadService.actualizarSuscripcionPorCiudad(suscripcionPorCiudadMapper.toEntity(suscripcion)));
    }

    public void eliminarSuscripcion(Long id, Long idCiudad) {
        suscripcionPorCiudadService.eliminarSuscripcion(id, idCiudad);
    }

    public SuscripcionPorCiudadDTO consultarPorId(Long id) {
        return suscripcionPorCiudadMapper.toDto(suscripcionPorCiudadService.consultarPorId(id));
    }

}
