package projeto.dc.api_rest.api.dto.quizcharada;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuizCharadaCriacaoDto {
    @NotNull
    private Integer acerto;
    @NotNull
    private Integer erro;
}
