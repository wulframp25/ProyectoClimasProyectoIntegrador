package co.edu.udea.arquitectura.service;

import co.edu.udea.arquitectura.entity.Pais;
import co.edu.udea.arquitectura.exception.BusinessException;
import co.edu.udea.arquitectura.repository.PaisRepository;
import co.edu.udea.arquitectura.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PaisService {

    private final PaisRepository paisRepository;
    private final Messages messages;

    public PaisService(PaisRepository paisRepository, Messages messages) {
        this.paisRepository = paisRepository;
        this.messages = messages;
    }

    public Pais guardarPais(Pais pais) {

        Optional<Pais> paisConsulta = paisRepository.findByNombre(pais.getNombre());
        if(paisConsulta.isPresent()){
            throw new BusinessException(messages.get("pais.nombre.duplicado"));
        }
        return paisRepository.save(pais);
    }

    public Pais actualizarPais(Pais pais) {
        if (Objects.isNull(pais.getId())) {
            throw new BusinessException(messages.get("pais.id.vacio"));
        }
        consultarPorId(pais.getId());
        return paisRepository.save(pais);
    }


    public void eliminarPais(Long id) {
        consultarPorId(id);
        paisRepository.deleteById(id);
    }

    public Pais consultarPorId(Long id) {
        return paisRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("pais.id.no_encontrado")));
    }

    public List<Pais> buscarTodos() {
        return paisRepository.findAll();
    }
}
