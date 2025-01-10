package projeto.dc.api_rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.dc.api_rest.api.dto.mapper.PersonagemMapper;
import projeto.dc.api_rest.api.dto.personagem.PersonagemCriacaoDto;
import projeto.dc.api_rest.api.entity.Personagem;
import projeto.dc.api_rest.api.repository.PersonagemRepository;

import java.util.List;

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

    public Personagem persongemPorId(Long id) {
        Personagem personagem = personagemRepository.findByIdAndAtivoTrue(id);
        if (personagem == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return personagem;
    }

    public List<Personagem> listarPersonagensDesativados() {
        return personagemRepository.findByAtivoFalse();
    }

    public Personagem atualizarPersonagem(Long id, PersonagemCriacaoDto personagemAtt) {
        Personagem personagemAtual = personagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        personagemAtual.setNome(personagemAtt.getNome());
        personagemAtual.setOrigem(personagemAtt.getOrigem());

        return personagemRepository.save(personagemAtual);
    }

    public void desativarPersonagem(Long id) {
        Personagem personagemDesativar = personagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!personagemDesativar.getAtivo()) throw new ResponseStatusException(HttpStatus.CONFLICT);

        personagemDesativar.setAtivo(false);
        personagemRepository.save(personagemDesativar);
    }

    public Personagem reativarPersonagem(Long id) {
        Personagem personagemReativar = personagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (personagemReativar.getAtivo()) throw new ResponseStatusException(HttpStatus.CONFLICT);

        personagemReativar.setAtivo(true);

        return personagemRepository.save(personagemReativar);
    }
}
