package projeto.dc.api_rest.api.dto.personagem;

import lombok.Data;

@Data
public class PersonagemListagemDto {
    private Long id;
    private String nome;
    private String origem;
    private String foto;
}
