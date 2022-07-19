package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.entity.Ciudad;
import co.edu.udea.arquitectura.entity.SuscripcionPorCiudad;
import co.edu.udea.arquitectura.mapper.CiudadMapper;
import co.edu.udea.arquitectura.modelo.CiudadDTO;
import co.edu.udea.arquitectura.service.CiudadService;
import co.edu.udea.arquitectura.service.SuscripcionPorCiudadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class CiudadFacade {

    private final CiudadService ciudadService;
    private final CiudadMapper ciudadMapper;
    private final SuscripcionPorCiudadService suscripcionPorCiudadService;

    public CiudadFacade(CiudadService ciudadService, CiudadMapper ciudadMapper,
                        SuscripcionPorCiudadService suscripcionPorCiudadService) {
        this.ciudadService = ciudadService;
        this.ciudadMapper = ciudadMapper;
        this.suscripcionPorCiudadService = suscripcionPorCiudadService;
    }

    public CiudadDTO guardarCiudad(CiudadDTO ciudad) {
        return ciudadMapper.toDto(ciudadService.guardarCiudad(ciudadMapper.toEntity(ciudad)));
    }

    public CiudadDTO actualizarCiudad(CiudadDTO ciudad) {
        return ciudadMapper.toDto(ciudadService.actualizarCiudad(ciudadMapper.toEntity(ciudad)));
    }

    public void eliminarCiudad(Long id) {
        ciudadService.eliminarCiudad(id);
    }

    public CiudadDTO consultarPorId(Long id) {
        return ciudadMapper.toDto(ciudadService.consultarPorId(id));
    }

    public List<CiudadDTO> buscarTodas(Long id) {
        List<CiudadDTO> ciudadDTOList = ciudadMapper.toDto(ciudadService.buscarTodas());
        if (!Objects.isNull(id)) {
            List<SuscripcionPorCiudad> suscripcionPorCiudadList = suscripcionPorCiudadService.buscarPorCodigoUsuario(id);
            if (!suscripcionPorCiudadList.isEmpty()) {
                List<Ciudad> ciudadList = suscripcionPorCiudadList.stream().map(SuscripcionPorCiudad::getCiudad).collect(Collectors.toList());
                ciudadDTOList.forEach(ciudadDTO -> {
                    if (ciudadList.stream().anyMatch(ciudad -> ciudad.getId().equals(ciudadDTO.getId()))) {
                        ciudadDTO.setTieneSuscripcion(true);
                    }
                });
            }
        }
        return ciudadDTOList;
    }
}
