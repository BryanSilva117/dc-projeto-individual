package projeto.dc.api_rest.api.dto.personagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonagemCriacaoDto {
    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String origem;
    @NotBlank
    @NotNull
    private String foto;
}
