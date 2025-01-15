package projeto.dc.api_rest.api.dto.mapper;


import org.springframework.stereotype.Component;
import projeto.dc.api_rest.api.dto.personagem.PersonagemCriacaoDto;
import projeto.dc.api_rest.api.dto.personagem.PersonagemListagemDto;
import projeto.dc.api_rest.api.entity.Personagem;

import java.util.List;

@Component
public class PersonagemMapper {

    public static Personagem toEntity(PersonagemCriacaoDto dto) {
        if (dto == null) return null;

        Personagem personagem = new Personagem();
        personagem.setNome(dto.getNome());
        personagem.setOrigem(dto.getOrigem());
        personagem.setAtivo(true);
        personagem.setFoto(dto.getFoto());
        personagem.setNomesAlternativos(dto.getNomesAlternativos());

        return personagem;
    }

    public static PersonagemListagemDto toDto(Personagem entity) {
        if (entity == null) return null;

        PersonagemListagemDto dto = new PersonagemListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setOrigem(entity.getOrigem());
        dto.setFoto(entity.getFoto());
        dto.setNomesAlternativos(entity.getNomesAlternativos());
        return dto;
    }

    public static List<PersonagemListagemDto> toDto(List<Personagem> entities) {
        return entities.stream().map(PersonagemMapper::toDto).toList();
    }
}
