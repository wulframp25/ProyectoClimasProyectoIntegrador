package co.edu.udea.arquitectura.service;

import co.edu.udea.arquitectura.entity.Ciudad;
import co.edu.udea.arquitectura.entity.Estado;
import co.edu.udea.arquitectura.entity.Suscripcion;
import co.edu.udea.arquitectura.exception.BusinessException;
import co.edu.udea.arquitectura.repository.SuscripcionRepository;
import co.edu.udea.arquitectura.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;
    private final Messages messages;

    public SuscripcionService(SuscripcionRepository suscripcionRepository, Messages messages) {
        this.suscripcionRepository = suscripcionRepository;
        this.messages = messages;
    }

    public Suscripcion guardarSuscripcion(Suscripcion suscripcion){
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion actualizarSuscripcion(Suscripcion suscripcion){
        if(Objects.isNull(suscripcion.getId())){
            throw new BusinessException(messages.get("suscripcion.id.vacio"));
        }
        consultarPorId(suscripcion.getId());
        return suscripcionRepository.save(suscripcion);
    }
    public Suscripcion consultarPorId(Long id){
        return suscripcionRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("suscripcion.id.no_encontrada")));
    }

    public void eliminarSuscripcion(Long id){
        consultarPorId(id);
        suscripcionRepository.deleteById(id);
    }
}
