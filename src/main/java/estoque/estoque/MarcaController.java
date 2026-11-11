package estoque.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository repository;

    @GetMapping
    public List<Marca> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Marca cadastrar(@RequestBody Marca marca) {
        return repository.save(marca);
    }
}
