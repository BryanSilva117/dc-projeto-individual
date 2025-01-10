package projeto.dc.api_rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.dc.api_rest.api.entity.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByAtivoTrue();
    Cliente findByIdAndAtivoTrue(Long id);
    Boolean existsByEmail(String email);
}
