package co.edu.udea.arquitectura.service;

import co.edu.udea.arquitectura.entity.Estado;
import co.edu.udea.arquitectura.exception.BusinessException;
import co.edu.udea.arquitectura.repository.EstadoRepository;
import co.edu.udea.arquitectura.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class EstadoService {
    private final EstadoRepository estadoRepository;
    private final Messages messages;

    public EstadoService(EstadoRepository estadoRepository, Messages messages) {
        this.estadoRepository = estadoRepository;
        this.messages = messages;
    }

    public Estado guardarEstado(Estado estado) {

        Optional<Estado> paisConsulta = estadoRepository.findByNombre(estado.getNombre());
        if(paisConsulta.isPresent()){
            throw new BusinessException(messages.get("estado.nombre.duplicado"));
        }
        return estadoRepository.save(estado);
    }

    public Estado actualizarEstado(Estado estado) {
        if (Objects.isNull(estado.getId())) {
            throw new BusinessException(messages.get("estado.id.vacio"));
        }
        consultarPorId(estado.getId());
        return estadoRepository.save(estado);
    }


    public void eliminarEstado(Long id) {
        consultarPorId(id);
        estadoRepository.deleteById(id);
    }

    public Estado consultarPorId(Long id) {
        return estadoRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("estado.id.no_encontrado")));
    }

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }
}
