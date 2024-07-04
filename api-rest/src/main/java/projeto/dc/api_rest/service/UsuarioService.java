package projeto.dc.api_rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.dc.api_rest.dto.mapper.UsuarioMapper;
import projeto.dc.api_rest.dto.usuario.UsuarioCriacaoDto;
import projeto.dc.api_rest.entity.Personagem;
import projeto.dc.api_rest.entity.Usuario;
import projeto.dc.api_rest.repository.UsuarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PersonagemService personagemService;

    public Usuario criarUsuario(UsuarioCriacaoDto usuarioCriacao) {
        if (usuarioCriacao == null) return null;

        Personagem personagem = personagemService.persongemPorId(usuarioCriacao.getPersonagemId());
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Usuario usuario = UsuarioMapper.toEntity(usuarioCriacao, personagem);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findByAtivoTrue();
    }

    public Usuario usuarioPorId(Integer id) {
        Usuario usuario = usuarioRepository.findByIdAndAtivoTrue(id);
        if (usuario == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return usuario;
    }

    public Usuario atualizarUsuario(Integer id, UsuarioCriacaoDto usuarioAtt) {
        Usuario usuarioAtual = usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        usuarioAtual.setNome(usuarioAtt.getNome());
        usuarioAtual.setSobrenome(usuarioAtt.getSobrenome());
        usuarioAtual.setEmail(usuarioAtt.getEmail());
        usuarioAtual.setSenha(usuarioAtt.getSenha());
        usuarioAtual.setDataNascimento(usuarioAtt.getDataNascimento());
        usuarioAtual.setGenero(usuarioAtt.getGenero());

        Personagem personagem = personagemService.persongemPorId(usuarioAtt.getPersonagemId());
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        usuarioAtual.setPersonagem(personagem);

        return usuarioRepository.save(usuarioAtual);
    }

    public Usuario atualizarBiografiaUsuario(Integer id, String biografia) {
        Usuario usuarioAtual = usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        usuarioAtual.setBiografia(biografia);

        return usuarioRepository.save(usuarioAtual);
    }

    public void desativarUsuario(Integer id) {
        Usuario usuarioDesativar = usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!usuarioDesativar.getAtivo()) throw new ResponseStatusException(HttpStatus.CONFLICT);

        usuarioDesativar.setAtivo(false);

        usuarioRepository.save(usuarioDesativar);
    }
}
