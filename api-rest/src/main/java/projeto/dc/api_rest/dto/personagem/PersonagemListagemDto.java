package projeto.dc.api_rest.dto.personagem;

import lombok.Data;

@Data
public class PersonagemListagemDto {
    private Integer id;
    private String nome;
    private String origem;
    private String foto;
}
