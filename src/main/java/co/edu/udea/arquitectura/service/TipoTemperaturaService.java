package co.edu.udea.arquitectura.service;

import co.edu.udea.arquitectura.entity.Pais;
import co.edu.udea.arquitectura.entity.TipoTemperatura;
import co.edu.udea.arquitectura.exception.BusinessException;
import co.edu.udea.arquitectura.repository.TipoTemperaturaRepository;
import co.edu.udea.arquitectura.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class TipoTemperaturaService {

    private final TipoTemperaturaRepository tipoTemperaturaRepository;
    private final Messages messages;

    public TipoTemperaturaService(TipoTemperaturaRepository tipoTemperaturaRepository, Messages messages) {
        this.tipoTemperaturaRepository = tipoTemperaturaRepository;
        this.messages = messages;
    }

    public TipoTemperatura guardarTipo(TipoTemperatura tipoTemperatura){
        Optional<TipoTemperatura> tipoTemperaturaConsulta= tipoTemperaturaRepository.findByNombre(tipoTemperatura.getNombre());
        if(tipoTemperaturaConsulta.isPresent()){
            throw new BusinessException(messages.get("tipo.nombre.duplicado"));
        }
        consultarPorId(tipoTemperatura.getId());
        return tipoTemperaturaRepository.save(tipoTemperatura);
    }

    public TipoTemperatura actualizarTipo(TipoTemperatura tipoTemperatura){
        if(Objects.isNull(tipoTemperatura.getId())){
            throw new BusinessException(messages.get("tipo.id.vacio"));
        }
        consultarPorId(tipoTemperatura.getId());
        return tipoTemperaturaRepository.save(tipoTemperatura);
    }

    public TipoTemperatura consultarPorId(Long id) {
        return tipoTemperaturaRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("tipo.id.no_encontrado")));
    }

    public void eliminarTipo(Long id){
        consultarPorId(id);
        tipoTemperaturaRepository.deleteById(id);
    }
}
