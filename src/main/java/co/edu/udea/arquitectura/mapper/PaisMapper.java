package co.edu.udea.arquitectura.mapper;

import co.edu.udea.arquitectura.config.EntityMapper;
import co.edu.udea.arquitectura.entity.Pais;
import co.edu.udea.arquitectura.modelo.PaisDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper extends EntityMapper<PaisDTO, Pais> {
}
