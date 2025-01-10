package projeto.dc.api_rest.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dc.api_rest.domain.usuario.Usuario;
import projeto.dc.api_rest.domain.usuario.repository.UsuarioRepository;
import projeto.dc.api_rest.service.usuario.dto.UsuarioCriacaoDto;
import projeto.dc.api_rest.service.usuario.dto.UsuarioMapper;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criar(UsuarioCriacaoDto usuarioCriacaoDto) {
        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);
        this.usuarioRepository.save(novoUsuario);
    }
}
