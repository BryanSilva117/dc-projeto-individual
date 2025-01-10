package projeto.dc.api_rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.dc.api_rest.api.dto.mapper.ClienteMapper;
import projeto.dc.api_rest.api.dto.cliente.ClienteCriacaoDto;
import projeto.dc.api_rest.api.entity.Personagem;
import projeto.dc.api_rest.api.entity.Cliente;
import projeto.dc.api_rest.api.repository.ClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository usuarioRepository;
    private final PersonagemService personagemService;

    public Cliente criarUsuario(ClienteCriacaoDto usuarioCriacao) {
        if (usuarioCriacao == null) return null;

        Personagem personagem = personagemService.persongemPorId(usuarioCriacao.getPersonagemId());
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Cliente cliente = ClienteMapper.toEntity(usuarioCriacao, personagem);
        return usuarioRepository.save(cliente);
    }

    public List<Cliente> listarUsuarios() {
        return usuarioRepository.findByAtivoTrue();
    }

    public Cliente usuarioPorId(Long id) {
        Cliente cliente = usuarioRepository.findByIdAndAtivoTrue(id);
        if (cliente == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return cliente;
    }

    public Cliente atualizarUsuario(Long id, ClienteCriacaoDto usuarioAtt) {
        Cliente clienteAtual = usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        clienteAtual.setNome(usuarioAtt.getNome());
        clienteAtual.setSobrenome(usuarioAtt.getSobrenome());
        clienteAtual.setEmail(usuarioAtt.getEmail());
        clienteAtual.setSenha(usuarioAtt.getSenha());
        clienteAtual.setDataNascimento(usuarioAtt.getDataNascimento());
        clienteAtual.setGenero(usuarioAtt.getGenero());

        Personagem personagem = personagemService.persongemPorId(usuarioAtt.getPersonagemId());
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        clienteAtual.setPersonagem(personagem);

        return usuarioRepository.save(clienteAtual);
    }

    public Cliente atualizarBiografiaUsuario(Long id, String biografia) {
        Cliente clienteAtual = usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        clienteAtual.setBiografia(biografia);

        return usuarioRepository.save(clienteAtual);
    }

    public void desativarUsuario(Long id) {
        Cliente clienteDesativar = usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!clienteDesativar.getAtivo()) throw new ResponseStatusException(HttpStatus.CONFLICT);

        clienteDesativar.setAtivo(false);

        usuarioRepository.save(clienteDesativar);
    }
}
