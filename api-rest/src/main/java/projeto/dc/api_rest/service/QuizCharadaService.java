package projeto.dc.api_rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.dc.api_rest.api.dto.mapper.QuizCharadaMapper;
import projeto.dc.api_rest.api.dto.quizcharada.QuizCharadaCriacaoDto;
import projeto.dc.api_rest.api.entity.QuizCharada;
import projeto.dc.api_rest.api.entity.Cliente;
import projeto.dc.api_rest.api.repository.QuizCharadaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizCharadaService {

    private final QuizCharadaRepository quizCharadaRepository;
    private final ClienteService usuarioService;

    public QuizCharada criarQuiz(QuizCharadaCriacaoDto quizCriacao, Long id) {
        if (quizCriacao == null) return null;
        Cliente cliente = usuarioService.usuarioPorId(id);
        if (cliente == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        QuizCharada quizCharada = QuizCharadaMapper.toEntity(quizCriacao, cliente);

        return quizCharadaRepository.save(quizCharada);
    }

    public List<QuizCharada> listarQuiz() {
        return quizCharadaRepository.findAll();
    }

    public QuizCharada quizPorId(Long id) {
       Optional<QuizCharada> quizCharada = quizCharadaRepository.findById(id);
        return quizCharada.orElse(null);
    }

}
