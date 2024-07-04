package projeto.dc.api_rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.dc.api_rest.dto.mapper.PersonagemMapper;
import projeto.dc.api_rest.dto.personagem.PersonagemCriacaoDto;
import projeto.dc.api_rest.entity.Personagem;
import projeto.dc.api_rest.repository.PersonagemRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public Personagem criarPersonagem(PersonagemCriacaoDto personagemCriacaoDto) {
        if (personagemCriacaoDto == null) return null;
        Personagem personagem = PersonagemMapper.toEntity(personagemCriacaoDto);
        return personagemRepository.save(personagem);
    }

    public List<Personagem> listarPersonagens() {
        return personagemRepository.findByAtivoTrue();
    }

    public Personagem persongemPorId(Integer id) {
        Personagem personagem = personagemRepository.findByIdAndAtivoTrue(id);
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return personagem;
    }

    public List<Personagem> listarPersonagensDesativados() {
        return personagemRepository.findByAtivoFalse();
    }

    public Personagem atualizarPersonagem(Integer id, PersonagemCriacaoDto personagemAtt) {
        Personagem personagemAtual = personagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        personagemAtual.setNome(personagemAtt.getNome());
        personagemAtual.setOrigem(personagemAtt.getOrigem());

        return personagemRepository.save(personagemAtual);
    }

    public void desativarPersonagem(Integer id) {
        Personagem personagemDesativar = personagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!personagemDesativar.getAtivo()) throw new ResponseStatusException(HttpStatus.CONFLICT);

        personagemDesativar.setAtivo(false);
        personagemRepository.save(personagemDesativar);
    }

    public Personagem reativarPersonagem(Integer id) {
        Personagem personagemReativar = personagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (personagemReativar.getAtivo()) throw new ResponseStatusException(HttpStatus.CONFLICT);

        personagemReativar.setAtivo(true);

        return personagemRepository.save(personagemReativar);
    }
}
