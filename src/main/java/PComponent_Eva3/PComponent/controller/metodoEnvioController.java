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

import PComponent_Eva3.PComponent.model.metodoenvio;
import PComponent_Eva3.PComponent.service.metodoenvioService;

@RestController
@RequestMapping("/api/metodoEnvio")
public class metodoEnvioController {

    @Autowired
    private metodoenvioService metodoenvioService;

    @GetMapping
    public ResponseEntity<List<metodoenvio>> getAllMetodos() {
        List<metodoenvio> metodoenvio = metodoenvioService.findAll();
        if (metodoenvio.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoenvio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<metodoenvio> getMetodoById(@PathVariable Integer id) {
        metodoenvio metodoenvio = metodoenvioService.findById(id);
        if (metodoenvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoenvio);
    }

    @PostMapping
    public ResponseEntity<metodoenvio> createMetodoEnvio(@RequestBody metodoenvio metodoenvio) {
        metodoenvio createdMetodoEnvio = metodoenvioService.save(metodoenvio);
        return ResponseEntity.status(201).body(createdMetodoEnvio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<metodoenvio> updateMetodoEnvio(@PathVariable Integer id, @RequestBody metodoenvio metodoenvio) {
        metodoenvio.setId(id);
        metodoenvio updatedMetodoEnvio = metodoenvioService.save(metodoenvio);
        if (updatedMetodoEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMetodoEnvio);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<metodoenvio> updatePartialMetodoEnvio(@PathVariable Integer id, @RequestBody metodoenvio metodoenvio) {
        metodoenvio.setId(id);
        metodoenvio updatedMetodoEnvio = metodoenvioService.partialUpdate(metodoenvio);
        if (updatedMetodoEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMetodoEnvio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoEnvio(@PathVariable Integer id) {
        metodoenvioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
