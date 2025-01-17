package projeto.dc.api_rest.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.dc.api_rest.api.dto.mapper.QuizCharadaMapper;
import projeto.dc.api_rest.api.dto.quizcharada.QuizCharadaCriacaoDto;
import projeto.dc.api_rest.api.dto.quizcharada.QuizCharadaListagemDto;
import projeto.dc.api_rest.api.entity.QuizCharada;
import projeto.dc.api_rest.service.QuizCharadaService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quizes")
public class QuizCharadaController {

    private final QuizCharadaService quizCharadaService;

    @PostMapping("/{id}")
    public ResponseEntity<QuizCharadaListagemDto> criar(@RequestBody @Valid QuizCharadaCriacaoDto criarQuiz, @PathVariable Long id) {
        QuizCharada quizCharada = quizCharadaService.criarQuiz(criarQuiz, id);
        QuizCharadaListagemDto quizCharadaListagemDto = QuizCharadaMapper.toDto(quizCharada);

        URI uri = URI.create("/quizes/" + quizCharadaListagemDto.getId());
        return ResponseEntity.created(uri).body(quizCharadaListagemDto);
    }

    @GetMapping
    public ResponseEntity<List<QuizCharadaListagemDto>> listar() {
        List<QuizCharada> quizCharadas = quizCharadaService.listarQuiz();

        if (quizCharadas.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(QuizCharadaMapper.toDto(quizCharadas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizCharadaListagemDto> porId(@PathVariable Long id) {
        QuizCharada quizCharada = quizCharadaService.quizPorId(id);

        if (quizCharada == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(QuizCharadaMapper.toDto(quizCharada));
    }
}
