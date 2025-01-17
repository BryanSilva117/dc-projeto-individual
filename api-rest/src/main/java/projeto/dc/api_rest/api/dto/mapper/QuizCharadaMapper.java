package projeto.dc.api_rest.api.dto.mapper;

import projeto.dc.api_rest.api.dto.quizcharada.QuizCharadaCriacaoDto;
import projeto.dc.api_rest.api.dto.quizcharada.QuizCharadaListagemDto;
import projeto.dc.api_rest.api.entity.QuizCharada;
import projeto.dc.api_rest.api.entity.Cliente;

import java.util.List;

public class QuizCharadaMapper {

    public static QuizCharada toEntity(QuizCharadaCriacaoDto dto, Cliente cliente) {
        if (dto == null) return null;

        QuizCharada quizCharada = new QuizCharada();
        quizCharada.setCliente(cliente);
        quizCharada.setAcerto(dto.getAcerto());
        quizCharada.setErro(dto.getErro());

        return quizCharada;
    }

    public static QuizCharadaListagemDto toDto(QuizCharada entity) {
        if (entity == null) return null;

        QuizCharadaListagemDto dto = new QuizCharadaListagemDto();
        dto.setId(entity.getId());
        dto.setCliente(entity.getCliente());
        dto.setAcerto(entity.getAcerto());
        dto.setErro(entity.getErro());

        return dto;
    }

    public static List<QuizCharadaListagemDto> toDto(List<QuizCharada> entities) {
        return entities.stream().map(QuizCharadaMapper::toDto).toList();
    }
}
