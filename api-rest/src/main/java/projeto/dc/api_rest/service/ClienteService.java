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
import projeto.dc.api_rest.domain.usuario.Usuario;
import projeto.dc.api_rest.service.usuario.UsuarioService;
import projeto.dc.api_rest.service.usuario.dto.UsuarioCriacaoDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final UsuarioService usuarioService;
    private final ClienteRepository clienteRepository;
    private final PersonagemService personagemService;

    public Cliente criarUsuario(ClienteCriacaoDto clienteCriacao) {
        if (clienteCriacao == null) return null;

        Personagem personagem = personagemService.persongemPorId(clienteCriacao.getPersonagemId());
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado");

        if (clienteRepository.existsByEmail(clienteCriacao.getEmail())) throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse Email");
        Cliente cliente = ClienteMapper.toEntity(clienteCriacao, personagem);

        UsuarioCriacaoDto usuarioCriacaoDto = new UsuarioCriacaoDto();
        usuarioCriacaoDto.setNome(clienteCriacao.getNome());
        usuarioCriacaoDto.setEmail(clienteCriacao.getEmail());
        usuarioCriacaoDto.setSenha(clienteCriacao.getSenha());
        Usuario usuarioCriado = usuarioService.criar(usuarioCriacaoDto);
        cliente.setUsuario(usuarioCriado);

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarUsuarios() {
        return clienteRepository.findByAtivoTrue();
    }

    public Cliente usuarioPorId(Long id) {
        Cliente cliente = clienteRepository.findByIdAndAtivoTrue(id);
        if (cliente == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return cliente;
    }

    public Cliente atualizarUsuario(Long id, ClienteCriacaoDto usuarioAtt) {
        Cliente clienteAtual = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        clienteAtual.setNome(usuarioAtt.getNome());
        clienteAtual.setSobrenome(usuarioAtt.getSobrenome());
        clienteAtual.setEmail(usuarioAtt.getEmail());
        clienteAtual.setSenha(usuarioAtt.getSenha());
        clienteAtual.setDataNascimento(usuarioAtt.getDataNascimento());
        clienteAtual.setGenero(usuarioAtt.getGenero());

        Personagem personagem = personagemService.persongemPorId(usuarioAtt.getPersonagemId());
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        clienteAtual.setPersonagem(personagem);

        return clienteRepository.save(clienteAtual);
    }

    public Cliente atualizarBiografiaUsuario(Long id, String biografia) {
        Cliente clienteAtual = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        clienteAtual.setBiografia(biografia);

        return clienteRepository.save(clienteAtual);
    }

    public void desativarUsuario(Long id) {
        Cliente clienteDesativar = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!clienteDesativar.getAtivo()) throw new ResponseStatusException(HttpStatus.CONFLICT);

        clienteDesativar.setAtivo(false);

        clienteRepository.save(clienteDesativar);
    }
}
