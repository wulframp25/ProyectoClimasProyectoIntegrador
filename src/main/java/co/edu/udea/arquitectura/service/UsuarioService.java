package co.edu.udea.arquitectura.service;

import co.edu.udea.arquitectura.entity.Usuario;
import co.edu.udea.arquitectura.exception.BusinessException;
import co.edu.udea.arquitectura.repository.UsuarioRepository;
import co.edu.udea.arquitectura.util.Messages;
import co.edu.udea.arquitectura.util.enums.TipoUsuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final Messages messages;

    public UsuarioService(UsuarioRepository usuarioRepository, Messages messages) {
        this.usuarioRepository = usuarioRepository;
        this.messages = messages;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioConsulta = usuarioRepository.findByCorreo(usuario.getCorreo());
        if(usuarioConsulta.isPresent()){
            throw new BusinessException(messages.get("usuario.correo.duplicado"));
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        if (Objects.isNull(usuario.getId())) {
            throw new BusinessException(messages.get("usuario.id.vacio"));
        }
        consultarPorId(usuario.getId());
        return usuarioRepository.save(usuario);
    }


    public void eliminarUsuario(Long id) {
        consultarPorId(id);
        usuarioRepository.deleteById(id);
    }

    public Usuario consultarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("usuario.id.no_encontrado")));
    }

    public Usuario buscarUsuarioPorCorreo(String correo, String contrasena) {
        Usuario usuarioConsulta = usuarioRepository.findByCorreo(correo).orElseThrow(
                () -> new BusinessException(messages.get("usuario.correo.no_encontrado")));
        if (!usuarioConsulta.getContrasena().equals(contrasena)) {
            throw new BusinessException(messages.get("usuario.contrasena.no_valida"));
        }
        return usuarioConsulta;
    }
}
