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

import PComponent_Eva3.PComponent.model.venta;
import PComponent_Eva3.PComponent.service.ventaService;

@RestController
@RequestMapping("/api/venta")
public class ventaController {

    @Autowired
    private ventaService ventaService;

    @GetMapping
    public ResponseEntity<List<venta>> getAllVentas() {
        List<venta> ventas = ventaService.findAll();
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<venta> getVentaById(@PathVariable Integer id) {
        venta venta = ventaService.findById(id);
        if (venta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<venta> createVenta(@RequestBody venta venta) {
        venta createdVenta = ventaService.save(venta);
        return ResponseEntity.status(201).body(createdVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<venta> updateVenta(@PathVariable Integer id, @RequestBody venta venta) {
        venta.setId(id);
        venta updatedVenta = ventaService.save(venta);
        if (updatedVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVenta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<venta> updatePartialVenta(@PathVariable Integer id, @RequestBody venta venta) {
        venta.setId(id);
        venta updatedVenta = ventaService.partialUpdate(venta);
        if (updatedVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        ventaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

