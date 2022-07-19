package co.edu.udea.arquitectura.mapper;

import co.edu.udea.arquitectura.config.EntityMapper;
import co.edu.udea.arquitectura.entity.Estado;
import co.edu.udea.arquitectura.modelo.EstadoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaisMapper.class})
public interface EstadoMapper extends EntityMapper<EstadoDTO, Estado> {
}
