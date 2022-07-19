package co.edu.udea.arquitectura.mapper;

import co.edu.udea.arquitectura.config.EntityMapper;
import co.edu.udea.arquitectura.entity.Estado;
import co.edu.udea.arquitectura.entity.Suscripcion;
import co.edu.udea.arquitectura.modelo.EstadoDTO;
import co.edu.udea.arquitectura.modelo.SuscripcionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses={UsuarioMapper.class})
public interface SuscripcionMapper extends EntityMapper <SuscripcionDTO, Suscripcion>{
}
