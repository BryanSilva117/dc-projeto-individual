package projeto.dc.api_rest.dto.mapper;

import projeto.dc.api_rest.dto.quizcharada.QuizCharadaCriacaoDto;
import projeto.dc.api_rest.dto.quizcharada.QuizCharadaListagemDto;
import projeto.dc.api_rest.entity.QuizCharada;
import projeto.dc.api_rest.entity.Usuario;

import java.util.List;

public class QuizCharadaMapper {

    public static QuizCharada toEntity(QuizCharadaCriacaoDto dto, Usuario usuario) {
        if (dto == null) return null;

        QuizCharada quizCharada = new QuizCharada();
        quizCharada.setUsuario(usuario);
        quizCharada.setAcerto(dto.getAcerto());
        quizCharada.setErro(dto.getErro());

        return quizCharada;
    }

    public static QuizCharadaListagemDto toDto(QuizCharada entity) {
        if (entity == null) return null;

        QuizCharadaListagemDto dto = new QuizCharadaListagemDto();
        dto.setId(entity.getId());
        dto.setUsuario(entity.getUsuario());
        dto.setAcerto(entity.getAcerto());
        dto.setErro(entity.getErro());

        return dto;
    }

    public static List<QuizCharadaListagemDto> toDto(List<QuizCharada> entities) {
        return entities.stream().map(QuizCharadaMapper::toDto).toList();
    }
}
