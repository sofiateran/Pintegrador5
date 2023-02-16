package ProyectoIntegradorEQ5.demo.controller;

import ProyectoIntegradorEQ5.demo.Exceptions.ResourseNotFoundException;
import ProyectoIntegradorEQ5.demo.entidades.Categoria;
import ProyectoIntegradorEQ5.demo.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
@RequestMapping("/categorias")
@RestController
@AllArgsConstructor

public class CategoriaController {
    private final CategoriaService service;

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevasCategorias")
    public ResponseEntity<String> agregar(@RequestBody Categoria categoria) throws ResourseNotFoundException {
        service.agregar(categoria);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarCategorias")
    public ResponseEntity<String> modificar(@RequestBody Categoria categoria) {
        service.modificar(categoria);
        return ResponseEntity.ok("Se modifico la categoria");
    }

    @DeleteMapping("/eliminarCategorias")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourseNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la categoria con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
