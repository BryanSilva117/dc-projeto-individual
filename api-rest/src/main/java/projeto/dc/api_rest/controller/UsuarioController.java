package projeto.dc.api_rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.dc.api_rest.dto.mapper.UsuarioMapper;
import projeto.dc.api_rest.dto.usuario.UsuarioCriacaoDto;
import projeto.dc.api_rest.dto.usuario.UsuarioListagemDto;
import projeto.dc.api_rest.entity.Usuario;
import projeto.dc.api_rest.service.UsuarioService;

import java.net.URI;
import java.util.List;

@Api(tags = "UsuarioController", description = "Controller do usuario")
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation("Criar um novo usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuario criado."),
            @ApiResponse(code = 422, message = "Dados inválidos.")
    })
    @PostMapping
    public ResponseEntity<UsuarioListagemDto> criar(@RequestBody @Valid UsuarioCriacaoDto novoUsuario) {
        Usuario usuarioCriado = usuarioService.criarUsuario(novoUsuario);
        URI uri = URI.create("/usuarios/" + usuarioCriado.getId());
        return ResponseEntity.created(uri).body(UsuarioMapper.toDto(usuarioCriado));
    }

    @ApiOperation("Listar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario listado."),
            @ApiResponse(code = 204, message = "Não encontrado.")
    })
    @GetMapping
    public ResponseEntity<List<UsuarioListagemDto>> listar() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        if (usuarios.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(UsuarioMapper.toDto(usuarios));
    }

    @ApiOperation("Atualizar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Atualizado."),
            @ApiResponse(code = 404, message = "Não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioListagemDto> atualizar(@PathVariable Integer id, @RequestBody @Valid UsuarioCriacaoDto usuarioAtt) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioAtt);
        return ResponseEntity.ok(UsuarioMapper.toDto(usuarioAtualizado));
    }


    @PutMapping("/biografia/{id}")
    public ResponseEntity<UsuarioListagemDto> atualizarBiografia(@PathVariable Integer id, @RequestParam String biografia) {
        if (biografia == null) return ResponseEntity.badRequest().build();
        Usuario usuario = usuarioService.atualizarBiografiaUsuario(id, biografia);

        return ResponseEntity.ok(UsuarioMapper.toDto(usuario));
    }

    @ApiOperation("Desativar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario desativado."),
            @ApiResponse(code = 404, message = "Não encontrado.")
    })
    @PutMapping("/desativar/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {
        usuarioService.desativarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
