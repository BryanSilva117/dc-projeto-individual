package projeto.dc.api_rest.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.dc.api_rest.api.dto.mapper.ClienteMapper;
import projeto.dc.api_rest.api.dto.cliente.ClienteCriacaoDto;
import projeto.dc.api_rest.api.dto.cliente.ClienteListagemDto;
import projeto.dc.api_rest.api.entity.Cliente;
import projeto.dc.api_rest.service.ClienteService;

import java.net.URI;
import java.util.List;

@Api(tags = "UsuarioController", description = "Controller do usuario")
@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService usuarioService;

    @ApiOperation("Criar um novo usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuario criado."),
            @ApiResponse(code = 422, message = "Dados inválidos.")
    })
    @PostMapping
    public ResponseEntity<ClienteListagemDto> criar(@RequestBody @Valid ClienteCriacaoDto novoUsuario) {
        Cliente clienteCriado = usuarioService.criarUsuario(novoUsuario);
        URI uri = URI.create("/usuarios/" + clienteCriado.getId());
        return ResponseEntity.created(uri).body(ClienteMapper.toDto(clienteCriado));
    }

    @ApiOperation("Listar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario listado."),
            @ApiResponse(code = 204, message = "Não encontrado.")
    })
    @GetMapping
    public ResponseEntity<List<ClienteListagemDto>> listar() {
        List<Cliente> clientes = usuarioService.listarUsuarios();
        if (clientes.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ClienteMapper.toDto(clientes));
    }

    @ApiOperation("Atualizar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Atualizado."),
            @ApiResponse(code = 404, message = "Não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClienteListagemDto> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteCriacaoDto usuarioAtt) {
        Cliente clienteAtualizado = usuarioService.atualizarUsuario(id, usuarioAtt);
        return ResponseEntity.ok(ClienteMapper.toDto(clienteAtualizado));
    }


    @PutMapping("/biografia/{id}")
    public ResponseEntity<ClienteListagemDto> atualizarBiografia(@PathVariable Long id, @RequestParam String biografia) {
        if (biografia == null) return ResponseEntity.badRequest().build();
        Cliente cliente = usuarioService.atualizarBiografiaUsuario(id, biografia);

        return ResponseEntity.ok(ClienteMapper.toDto(cliente));
    }

    @ApiOperation("Desativar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario desativado."),
            @ApiResponse(code = 404, message = "Não encontrado.")
    })
    @PutMapping("/desativar/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        usuarioService.desativarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
