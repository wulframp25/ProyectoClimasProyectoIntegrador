package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.mapper.PaisMapper;
import co.edu.udea.arquitectura.modelo.PaisDTO;
import co.edu.udea.arquitectura.service.PaisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaisFacade {

    private final PaisService paisService;
    private final PaisMapper paisMapper;

    public PaisFacade(PaisService paisService, PaisMapper paisMapper) {
        this.paisService = paisService;
        this.paisMapper = paisMapper;
    }

    public PaisDTO guardarPais(PaisDTO pais) {
        return paisMapper.toDto(paisService.guardarPais(paisMapper.toEntity(pais)));
    }
    public PaisDTO actualizarPais(PaisDTO pais) {
        return paisMapper.toDto(paisService.actualizarPais(paisMapper.toEntity(pais)));
    }

    public void eliminarPais(Long id) {
        paisService.eliminarPais(id);
    }

    public PaisDTO consultarPorId(Long id) {
        return paisMapper.toDto(paisService.consultarPorId(id));
    }

    public List<PaisDTO> buscarTodos() {
        return paisMapper.toDto(paisService.buscarTodos());
    }

}
