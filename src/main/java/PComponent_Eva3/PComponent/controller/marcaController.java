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

import PComponent_Eva3.PComponent.model.marca;
import PComponent_Eva3.PComponent.service.marcaService;

@RestController
@RequestMapping("/api/marca")
public class marcaController {

    @Autowired
    private marcaService marcaService;

    @GetMapping
    public ResponseEntity<List<marca>> getAllMarcas() {
        List<marca> marca = marcaService.findAll();
        if (marca.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marca);
    }

    @GetMapping("/{id}")
    public ResponseEntity<marca> getMarcaById(@PathVariable Integer id) {
        marca marca = marcaService.findById(id);
        if (marca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public ResponseEntity<marca> createMarca(@RequestBody marca marca) {
        marca createdMarca = marcaService.save(marca);
        return ResponseEntity.status(201).body(createdMarca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<marca> updateMarca(@PathVariable Integer id, @RequestBody marca marca) {
        marca.setId(id);
        marca updatedMarca = marcaService.save(marca);
        if (updatedMarca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMarca);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<marca> updatePartialMarca(@PathVariable Integer id, @RequestBody marca marca) {
        marca.setId(id);
        marca updatedMarca = marcaService.partialUpdate(marca);
        if (updatedMarca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMarca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Integer id) {
        marcaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
