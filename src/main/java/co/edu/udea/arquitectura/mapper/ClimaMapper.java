package co.edu.udea.arquitectura.mapper;


import co.edu.udea.arquitectura.config.EntityMapper;
import co.edu.udea.arquitectura.entity.Clima;
import co.edu.udea.arquitectura.modelo.ClimaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ClimaMapper  extends EntityMapper <ClimaDTO, Clima>{
}