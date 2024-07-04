package projeto.dc.api_rest.dto.quizcharada;

import lombok.Data;
import projeto.dc.api_rest.entity.Usuario;

@Data
public class QuizCharadaListagemDto {
    private Integer id;
    private Usuario usuario;
    private Integer acerto;
    private Integer erro;
}
