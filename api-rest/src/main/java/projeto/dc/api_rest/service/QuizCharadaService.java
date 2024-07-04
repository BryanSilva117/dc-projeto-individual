package projeto.dc.api_rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.dc.api_rest.dto.mapper.QuizCharadaMapper;
import projeto.dc.api_rest.dto.quizcharada.QuizCharadaCriacaoDto;
import projeto.dc.api_rest.entity.QuizCharada;
import projeto.dc.api_rest.entity.Usuario;
import projeto.dc.api_rest.repository.QuizCharadaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizCharadaService {

    private final QuizCharadaRepository quizCharadaRepository;
    private final UsuarioService usuarioService;

    public QuizCharada criarQuiz(QuizCharadaCriacaoDto quizCriacao, Integer id) {
        if (quizCriacao == null) return null;
        Usuario usuario = usuarioService.usuarioPorId(id);
        if (usuario == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        QuizCharada quizCharada = QuizCharadaMapper.toEntity(quizCriacao, usuario);

        return quizCharadaRepository.save(quizCharada);
    }

    public List<QuizCharada> listarQuiz() {
        return quizCharadaRepository.findAll();
    }

    public QuizCharada quizPorId(Integer id) {
       Optional<QuizCharada> quizCharada = quizCharadaRepository.findById(id);
        return quizCharada.orElse(null);
    }

}
