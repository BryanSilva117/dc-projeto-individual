package projeto.dc.api_rest.dto.mapper;

import projeto.dc.api_rest.dto.personagem.PersonagemCriacaoDto;
import projeto.dc.api_rest.dto.usuario.UsuarioCriacaoDto;
import projeto.dc.api_rest.dto.usuario.UsuarioListagemDto;
import projeto.dc.api_rest.entity.Personagem;
import projeto.dc.api_rest.entity.Usuario;

import java.util.List;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCriacaoDto dto, Personagem personagem) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setGenero(dto.getGenero());
        usuario.setAtivo(true);
        usuario.setPersonagem(personagem);

        return usuario;
    }

    public static UsuarioListagemDto toDto(Usuario entity) {
        if (entity == null) return null;

        UsuarioListagemDto dto = new UsuarioListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSobrenome(entity.getSobrenome());
        dto.setBiografia(entity.getBiografia());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setGenero(entity.getGenero());
        dto.setPersonagem(entity.getPersonagem());

        return dto;
    }

    public static List<UsuarioListagemDto> toDto(List<Usuario> entities) {
        return entities.stream().map(UsuarioMapper::toDto).toList();
    }
}
