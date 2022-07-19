package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.mapper.EstadoMapper;
import co.edu.udea.arquitectura.modelo.EstadoDTO;
import co.edu.udea.arquitectura.service.EstadoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EstadoFacade {
    private final EstadoService estadoService;
    private final EstadoMapper estadoMapper;

    public EstadoFacade(EstadoService estadoService, EstadoMapper estadoMapper) {
        this.estadoService = estadoService;
        this.estadoMapper = estadoMapper;
    }

    public EstadoDTO guardarEstado(EstadoDTO estado) {
        return estadoMapper.toDto(estadoService.guardarEstado(estadoMapper.toEntity(estado)));
    }
    public EstadoDTO actualizarEstado(EstadoDTO estado) {
        return estadoMapper.toDto(estadoService.actualizarEstado(estadoMapper.toEntity(estado)));
    }

    public void eliminarEstado(Long id) {
        estadoService.eliminarEstado(id);
    }

    public EstadoDTO consultarPorId(Long id) {
        return estadoMapper.toDto(estadoService.consultarPorId(id));
    }

    public List<EstadoDTO> buscarTodos() {
        return estadoMapper.toDto(estadoService.buscarTodos());
    }
}
