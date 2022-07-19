package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.mapper.SuscripcionMapper;
import co.edu.udea.arquitectura.modelo.SuscripcionDTO;
import co.edu.udea.arquitectura.service.SuscripcionPorCiudadService;
import co.edu.udea.arquitectura.service.SuscripcionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SuscripcionFacade {
    private final SuscripcionService suscripcionService;
    private final SuscripcionMapper suscripcionMapper;
    private final SuscripcionPorCiudadService suscripcionPorCiudadService;

    public SuscripcionFacade(SuscripcionService suscripcionService, SuscripcionMapper suscripcionMapper,
                             SuscripcionPorCiudadService suscripcionPorCiudadService) {
        this.suscripcionService = suscripcionService;
        this.suscripcionMapper = suscripcionMapper;
        this.suscripcionPorCiudadService = suscripcionPorCiudadService;
    }

    public SuscripcionDTO guardarSuscripcion(SuscripcionDTO suscripcion) {
        return suscripcionMapper.toDto(suscripcionService.guardarSuscripcion(suscripcionMapper.toEntity(suscripcion)));
    }

    public SuscripcionDTO actualizarSuscripcion(SuscripcionDTO suscripcion) {
        return suscripcionMapper.toDto(suscripcionService.actualizarSuscripcion(suscripcionMapper.toEntity(suscripcion)));
    }

    public void eliminarSuscripcion(Long id) {
        suscripcionPorCiudadService.deleteByFkSuscripcion(id);
        suscripcionService.eliminarSuscripcion(id);
    }

    public SuscripcionDTO consultarPorId(Long id) {
        return suscripcionMapper.toDto(suscripcionService.consultarPorId(id));
    }
}
