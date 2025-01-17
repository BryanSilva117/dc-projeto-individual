package projeto.dc.api_rest.api.dto.cliente;

import lombok.Data;
import projeto.dc.api_rest.api.entity.Personagem;

import java.time.LocalDate;

@Data
public class ClienteListagemDto {
    private Long id;

    private String nome;
    private String sobrenome;
    private String biografia;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String genero;
    private Personagem personagem;
}
