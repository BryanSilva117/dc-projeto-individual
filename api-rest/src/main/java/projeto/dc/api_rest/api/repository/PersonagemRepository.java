package projeto.dc.api_rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projeto.dc.api_rest.api.entity.Personagem;

import java.util.List;
import java.util.Optional;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    List<Personagem> findByAtivoTrue();
    Personagem findByIdAndAtivoTrue(Long id);
    List<Personagem> findByAtivoFalse();

    @Query("SELECT p FROM Personagem p JOIN p.nomesAlternativos na WHERE LOWER(na) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Optional<List<Personagem>> findByNomeAlternativo(@Param("nome") String nome);
}
