package PComponent_Eva3.PComponent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PComponent_Eva3.PComponent.model.categoria;
import PComponent_Eva3.PComponent.service.categoriaService;

@RestController
@RequestMapping("/api/categoria")
public class categoriaController {

    @Autowired
    private categoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<categoria>> getAllCategorias() {
        List<categoria> categorias = categoriaService.findAll();
        if (categorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<categoria> getCategoriaById(@PathVariable Integer id) {
        categoria categoria = categoriaService.findById(id);
        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<categoria> createCategoria(@RequestBody categoria categoria) {
        categoria createdCategoria = categoriaService.save(categoria);
        return ResponseEntity.status(201).body(createdCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<categoria> updateCategoria(@PathVariable Integer id, @RequestBody categoria categoria) {
        categoria.setId(id);
        categoria updatedCategoria = categoriaService.save(categoria);
        if (updatedCategoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCategoria);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<categoria> updatePartialCategoria(@PathVariable Integer id, @RequestBody categoria categoria) {
        categoria.setId(id);
        categoria updatedCategoria = categoriaService.partialUpdate(categoria);
        if (updatedCategoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
