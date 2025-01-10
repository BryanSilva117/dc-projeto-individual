package projeto.dc.api_rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.dc.api_rest.api.entity.Personagem;

import java.util.List;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    List<Personagem> findByAtivoTrue();
    Personagem findByIdAndAtivoTrue(Long id);
    List<Personagem> findByAtivoFalse();
}
