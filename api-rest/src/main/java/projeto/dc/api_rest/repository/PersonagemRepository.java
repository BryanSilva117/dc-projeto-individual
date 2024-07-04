package projeto.dc.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.dc.api_rest.entity.Personagem;

import java.util.List;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
    List<Personagem> findByAtivoTrue();
    Personagem findByIdAndAtivoTrue(Integer id);
    List<Personagem> findByAtivoFalse();
}
