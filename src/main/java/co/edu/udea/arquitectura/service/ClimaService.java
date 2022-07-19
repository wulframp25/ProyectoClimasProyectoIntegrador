package co.edu.udea.arquitectura.service;

import co.edu.udea.arquitectura.entity.Clima;
import co.edu.udea.arquitectura.entity.Suscripcion;
import co.edu.udea.arquitectura.exception.BusinessException;
import co.edu.udea.arquitectura.repository.ClimaRepository;

import co.edu.udea.arquitectura.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ClimaService {
    private final ClimaRepository climaRepository;
    private final Messages messages;

    public ClimaService(ClimaRepository climaRepository, Messages messages) {
        this.climaRepository = climaRepository;
        this.messages = messages;
    }

    public Clima guardarClima(Clima clima){

        Optional<Clima> climaConsulta=climaRepository.findById(clima.getId());
        if(climaConsulta.isPresent()){
            throw new BusinessException(messages.get("clima.id.duplicado"));
        }
        return climaRepository.save(clima);
    }

    public Clima actualizarClima(Clima clima){
        if(Objects.isNull(clima.getId())){
            throw new BusinessException(messages.get("clima.id.vacio"));
        }
        consultarPorId(clima.getId());
        return climaRepository.save(clima);
    }
    public Clima consultarPorId(Long id){
        return climaRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("clima.id.no_encontrado")));
    }

    public void eliminarClima(Long id){
        consultarPorId(id);
        climaRepository.deleteById(id);
    }
}
