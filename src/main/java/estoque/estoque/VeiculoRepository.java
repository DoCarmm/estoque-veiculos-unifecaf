package estoque.estoque;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByStatusContainingIgnoreCase(String status);
    List<Veiculo> findByModeloContainingIgnoreCase(String modelo);
    List<Veiculo> findByAno(Integer ano);
    List<Veiculo> findByPrecoLessThanEqual(Double precoMaximo);
    List<Veiculo> findByMarcaNomeContainingIgnoreCase(String nomeMarca);
}
