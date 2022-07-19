package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.mapper.TipoTemperaturaMapper;
import co.edu.udea.arquitectura.modelo.TipoTemperaturaDTO;
import co.edu.udea.arquitectura.service.TipoTemperaturaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoTemperaturaFacade {

    private final TipoTemperaturaService tipoTemperaturaService;
    private final TipoTemperaturaMapper tipoTemperaturaMapper;

    public TipoTemperaturaFacade(TipoTemperaturaService tipoTemperaturaService, TipoTemperaturaMapper tipoTemperaturaMapper) {
        this.tipoTemperaturaService = tipoTemperaturaService;
        this.tipoTemperaturaMapper = tipoTemperaturaMapper;
    }

    public TipoTemperaturaDTO guardarTipo(TipoTemperaturaDTO tipo){
        return tipoTemperaturaMapper.toDto(tipoTemperaturaService.guardarTipo(tipoTemperaturaMapper.toEntity(tipo)));
    }

    public TipoTemperaturaDTO actualizarTipo(TipoTemperaturaDTO tipo){
        return tipoTemperaturaMapper.toDto(tipoTemperaturaService.actualizarTipo(tipoTemperaturaMapper.toEntity(tipo)));
    }

    public void eliminarTipo(Long id){
       tipoTemperaturaService.eliminarTipo(id);
    }

    public TipoTemperaturaDTO consultarPorId(Long id){
        return tipoTemperaturaMapper.toDto(tipoTemperaturaService.consultarPorId(id));
    }
}
