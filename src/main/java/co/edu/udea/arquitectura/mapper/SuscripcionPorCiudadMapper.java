package co.edu.udea.arquitectura.mapper;

import co.edu.udea.arquitectura.config.EntityMapper;
import co.edu.udea.arquitectura.entity.Estado;
import co.edu.udea.arquitectura.entity.SuscripcionPorCiudad;
import co.edu.udea.arquitectura.modelo.EstadoDTO;
import co.edu.udea.arquitectura.modelo.SuscripcionPorCiudadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses={SuscripcionMapper.class , CiudadMapper.class})
public interface SuscripcionPorCiudadMapper extends EntityMapper<SuscripcionPorCiudadDTO, SuscripcionPorCiudad> {
}
