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

import PComponent_Eva3.PComponent.service.envioService;
import PComponent_Eva3.PComponent.model.envio;

@RestController
@RequestMapping("/api/envio")
public class envioController {

    @Autowired
    private envioService envioService;

    @GetMapping
    public ResponseEntity<List<envio>> getAllEnvios() {
        List<envio> envios = envioService.findAll();
        if (envios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(envios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<envio> getEnvioById(@PathVariable Integer id) {
        envio envio = envioService.findById(id);
        if (envio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(envio);
    }

    @PostMapping
    public ResponseEntity<envio> createEnvio(@RequestBody envio envio) {
        envio createdEnvio = envioService.save(envio);
        return ResponseEntity.status(201).body(createdEnvio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<envio> updateEnvio(@PathVariable Integer id, @RequestBody envio envio) {
        envio.setId(id);
        envio updatedEnvio = envioService.save(envio);
        if (updatedEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEnvio);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<envio> updatePartialEnvio(@PathVariable Integer id, @RequestBody envio envio) {
        envio.setId(id);
        envio updatedEnvio = envioService.partialUpdate(envio);
        if (updatedEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEnvio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvio(@PathVariable Integer id) {
        envioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
