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
import projeto.dc.api_rest.api.dto.mapper.PersonagemMapper;
import projeto.dc.api_rest.api.dto.personagem.PersonagemCriacaoDto;
import projeto.dc.api_rest.api.dto.personagem.PersonagemListagemDto;
import projeto.dc.api_rest.api.entity.Personagem;
import projeto.dc.api_rest.service.PersonagemService;

import java.net.URI;
import java.util.List;

@Api(tags = "PersonagemController", description = "Controller do Personagem")
@RequiredArgsConstructor
@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @ApiOperation("Criar um novo personagem")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Personagem criado."),
            @ApiResponse(code = 422, message = "Dados inválidos.")
    })
    @PostMapping
    public ResponseEntity<PersonagemListagemDto> criar(@RequestBody @Valid PersonagemCriacaoDto novoPersonagem) {
        Personagem personagemCriado = personagemService.criarPersonagem(novoPersonagem);
        URI uri = URI.create("/personagens/" + personagemCriado.getId());
        return ResponseEntity.created(uri).body(PersonagemMapper.toDto(personagemCriado));
    }

    @ApiOperation("Listar personagem")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personagem listado."),
            @ApiResponse(code = 204, message = "Não encontrado.")
    })
    @GetMapping
    public ResponseEntity<List<PersonagemListagemDto>> listar() {
        List<Personagem> personagens = personagemService.listarPersonagens();
        if (personagens.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(PersonagemMapper.toDto(personagens));
    }

    @ApiOperation("Listar personagem desativado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personagem listado."),
            @ApiResponse(code = 204, message = "Não encontrado.")
    })
    @GetMapping("/listar-desativos")
    public ResponseEntity<List<PersonagemListagemDto>> listarDesativos() {
        List<Personagem> personagens = personagemService.listarPersonagensDesativados();
        if (personagens.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(PersonagemMapper.toDto(personagens));
    }

    @ApiOperation("Atualizar personagem")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personagem Atualizado."),
            @ApiResponse(code = 404, message = "Não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PersonagemListagemDto> atualizar(@PathVariable Long id, @RequestBody @Valid PersonagemCriacaoDto personagemAtt) {
        Personagem personagemAtualizado = personagemService.atualizarPersonagem(id, personagemAtt);
        return ResponseEntity.ok(PersonagemMapper.toDto(personagemAtualizado));
    }

    @ApiOperation("Desativar personagem")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personagem desativado."),
            @ApiResponse(code = 404, message = "Não encontrado.")
    })
    @PutMapping("/desativar/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        personagemService.desativarPersonagem(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("Reativar personagem")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personagem reativado."),
            @ApiResponse(code = 404, message = "Não encontrado.")
    })
    @PutMapping("/reativar/{id}")
    public ResponseEntity<PersonagemListagemDto> reativar(@PathVariable Long id) {
        Personagem personagem = personagemService.reativarPersonagem(id);
        return ResponseEntity.ok(PersonagemMapper.toDto(personagem));
    }

}
