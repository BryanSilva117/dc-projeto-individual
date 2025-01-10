package projeto.dc.api_rest.api.dto.quizcharada;

import lombok.Data;
import projeto.dc.api_rest.api.entity.Cliente;

@Data
public class QuizCharadaListagemDto {
    private Long id;
    private Cliente cliente;
    private Integer acerto;
    private Integer erro;
}
