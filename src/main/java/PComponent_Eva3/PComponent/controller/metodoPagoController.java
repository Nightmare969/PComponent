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

import PComponent_Eva3.PComponent.model.metodopago;
import PComponent_Eva3.PComponent.service.metodopagoService;

@RestController
@RequestMapping("/api/metodoPago")
public class metodoPagoController {

    @Autowired
    private metodopagoService metodopagoService;

    @GetMapping
    public ResponseEntity<List<metodopago>> getAllMetodos() {
        List<metodopago> metodopagos = metodopagoService.findAll();
        if (metodopagos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodopagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<metodopago> getMetodoById(@PathVariable Integer id) {
        metodopago metodopago = metodopagoService.findById(id);
        if (metodopago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodopago);
    }

    @PostMapping
    public ResponseEntity<metodopago> createMetodoPago(@RequestBody metodopago metodopago) {
        metodopago createdMetodoPago = metodopagoService.save(metodopago);
        return ResponseEntity.status(201).body(createdMetodoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<metodopago> updateMetodoPago(@PathVariable Integer id, @RequestBody metodopago metodopago) {
        metodopago.setId(id);
        metodopago updatedMetodoPago = metodopagoService.save(metodopago);
        if (updatedMetodoPago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMetodoPago);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<metodopago> updatePartialMetodoPago(@PathVariable Integer id, @RequestBody metodopago metodopago) {
        metodopago.setId(id);
        metodopago updatedMetodoPago = metodopagoService.partialUpdate(metodopago);
        if (updatedMetodoPago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMetodoPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Integer id) {
        metodopagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
