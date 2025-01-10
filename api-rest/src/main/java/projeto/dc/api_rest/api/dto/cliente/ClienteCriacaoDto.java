package projeto.dc.api_rest.api.dto.cliente;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ClienteCriacaoDto {
    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String sobrenome;
    @Email
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    @Size(min = 6)
    private String senha;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    @NotNull
    private String genero;
    @NotNull
    private Long personagemId;
}
