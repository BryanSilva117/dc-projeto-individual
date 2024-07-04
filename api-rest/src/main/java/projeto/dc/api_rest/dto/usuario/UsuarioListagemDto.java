package projeto.dc.api_rest.dto.usuario;

import lombok.Data;
import projeto.dc.api_rest.entity.Personagem;

import java.time.LocalDate;

@Data
public class UsuarioListagemDto {
    private Integer id;

    private String nome;
    private String sobrenome;
    private String biografia;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String genero;
    private Personagem personagem;
}
