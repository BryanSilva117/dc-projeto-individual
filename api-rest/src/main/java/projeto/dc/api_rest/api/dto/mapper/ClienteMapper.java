package projeto.dc.api_rest.api.dto.mapper;

import projeto.dc.api_rest.api.dto.cliente.ClienteCriacaoDto;
import projeto.dc.api_rest.api.dto.cliente.ClienteListagemDto;
import projeto.dc.api_rest.api.entity.Personagem;
import projeto.dc.api_rest.api.entity.Cliente;

import java.util.List;

public class ClienteMapper {

    public static Cliente toEntity(ClienteCriacaoDto dto, Personagem personagem) {
        if (dto == null) return null;

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setSobrenome(dto.getSobrenome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setGenero(dto.getGenero());
        cliente.setAtivo(true);
        cliente.setPersonagem(personagem);

        return cliente;
    }

    public static ClienteListagemDto toDto(Cliente entity) {
        if (entity == null) return null;

        ClienteListagemDto dto = new ClienteListagemDto();
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

    public static List<ClienteListagemDto> toDto(List<Cliente> entities) {
        return entities.stream().map(ClienteMapper::toDto).toList();
    }
}
