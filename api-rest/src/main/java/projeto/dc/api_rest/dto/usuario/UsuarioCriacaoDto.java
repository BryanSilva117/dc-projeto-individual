package projeto.dc.api_rest.dto.usuario;

import jakarta.validation.constraints.*;
import lombok.Data;
import projeto.dc.api_rest.entity.Personagem;

import java.time.LocalDate;
@Data
public class UsuarioCriacaoDto {
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
    private Integer personagemId;
}
