package projeto.dc.api_rest.service.usuario.autenticacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioTokenDto {

    private Long userId;
    private String nome;
    private String email;
    private String token;
}
