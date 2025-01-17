package projeto.dc.api_rest.api.dto.personagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

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

    @NotEmpty
    private List<String> nomesAlternativos;
}
