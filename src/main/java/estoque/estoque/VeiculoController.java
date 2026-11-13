package estoque.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return repository.save(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        veiculoAtualizado.setId(id);
        return repository.save(veiculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/filtro")
    public List<Veiculo> filtrar(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) Integer ano,
            @RequestParam(required = false) Double precoMaximo,
            @RequestParam(required = false) String marca) {

        if (status != null) return repository.findByStatusContainingIgnoreCase(status);
        if (modelo != null) return repository.findByModeloContainingIgnoreCase(modelo);
        if (ano != null) return repository.findByAno(ano);
        if (precoMaximo != null) return repository.findByPrecoLessThanEqual(precoMaximo);
        if (marca != null) return repository.findByMarcaNomeContainingIgnoreCase(marca);

        return repository.findAll();
    }
}
