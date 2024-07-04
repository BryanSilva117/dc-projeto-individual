package projeto.dc.api_rest.dto.mapper;


import org.springframework.stereotype.Component;
import projeto.dc.api_rest.dto.personagem.PersonagemCriacaoDto;
import projeto.dc.api_rest.dto.personagem.PersonagemListagemDto;
import projeto.dc.api_rest.entity.Personagem;

import java.util.List;

@Component
public class PersonagemMapper {

    public static Personagem toEntity(PersonagemCriacaoDto dto) {
        if (dto == null) return null;

        Personagem personagem = new Personagem();
        personagem.setNome(dto.getNome());
        personagem.setOrigem(dto.getOrigem());
        personagem.setAtivo(true);

        return personagem;
    }

    public static PersonagemListagemDto toDto(Personagem entity) {
        if (entity == null) return null;

        PersonagemListagemDto dto = new PersonagemListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setOrigem(entity.getOrigem());
        return dto;
    }

    public static List<PersonagemListagemDto> toDto(List<Personagem> entities) {
        return entities.stream().map(PersonagemMapper::toDto).toList();
    }
}
