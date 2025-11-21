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

import PComponent_Eva3.PComponent.model.Metodoenvio;
import PComponent_Eva3.PComponent.service.metodoenvioService;

@RestController
@RequestMapping("/api/metodoEnvio")
public class metodoEnvioController {

    @Autowired
    private metodoenvioService metodoenvioService;

    @GetMapping
    public ResponseEntity<List<Metodoenvio>> getAllMetodos() {
        List<Metodoenvio> metodoenvio = metodoenvioService.findAll();
        if (metodoenvio.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoenvio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metodoenvio> getMetodoById(@PathVariable Integer id) {
        Metodoenvio metodoenvio = metodoenvioService.findById(id);
        if (metodoenvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoenvio);
    }

    @PostMapping
    public ResponseEntity<Metodoenvio> createMetodoEnvio(@RequestBody Metodoenvio metodoenvio) {
        Metodoenvio createdMetodoEnvio = metodoenvioService.save(metodoenvio);
        return ResponseEntity.status(201).body(createdMetodoEnvio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metodoenvio> updateMetodoEnvio(@PathVariable Integer id, @RequestBody Metodoenvio metodoenvio) {
        metodoenvio.setId(id);
        Metodoenvio updatedMetodoEnvio = metodoenvioService.save(metodoenvio);
        if (updatedMetodoEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMetodoEnvio);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Metodoenvio> updatePartialMetodoEnvio(@PathVariable Integer id, @RequestBody Metodoenvio metodoenvio) {
        metodoenvio.setId(id);
        Metodoenvio updatedMetodoEnvio = metodoenvioService.partialUpdate(metodoenvio);
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
