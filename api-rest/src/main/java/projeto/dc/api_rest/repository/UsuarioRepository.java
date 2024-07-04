package projeto.dc.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.dc.api_rest.entity.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByAtivoTrue();
    Usuario findByIdAndAtivoTrue(Integer id);
}
