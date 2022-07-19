package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.mapper.ClimaMapper;
import co.edu.udea.arquitectura.modelo.ClimaDTO;
import co.edu.udea.arquitectura.service.ClimaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClimaFacade {
    private final ClimaService climaService;
    private final ClimaMapper climaMapper;

    public ClimaFacade(ClimaService climaService, ClimaMapper climaMapper) {
        this.climaService = climaService;
        this.climaMapper = climaMapper;
    }

    public ClimaDTO guardarClima(ClimaDTO clima){
        return climaMapper.toDto(climaService.guardarClima(climaMapper.toEntity(clima)));
    }

    public ClimaDTO actualizarClima(ClimaDTO clima){
        return climaMapper.toDto(climaService.actualizarClima(climaMapper.toEntity(clima)));
    }

    public void eliminarClima(Long id){
        climaService.eliminarClima(id);
    }

    public ClimaDTO consultarPorId(Long id){
        return climaMapper.toDto(climaService.consultarPorId(id));

    }
}
