package co.edu.udea.arquitectura.mapper;

import co.edu.udea.arquitectura.config.EntityMapper;
import co.edu.udea.arquitectura.entity.Ciudad;
import co.edu.udea.arquitectura.modelo.CiudadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class})
public interface CiudadMapper extends EntityMapper<CiudadDTO, Ciudad> {
}
