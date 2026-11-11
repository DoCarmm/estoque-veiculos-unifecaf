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
}
