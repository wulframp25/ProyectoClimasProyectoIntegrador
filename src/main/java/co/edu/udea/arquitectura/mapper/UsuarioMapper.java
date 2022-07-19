package co.edu.udea.arquitectura.mapper;

import co.edu.udea.arquitectura.config.EntityMapper;
import co.edu.udea.arquitectura.entity.Usuario;
import co.edu.udea.arquitectura.modelo.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CiudadMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
}
