package PComponent_Eva3.PComponent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PComponent_Eva3.PComponent.model.venta;
import PComponent_Eva3.PComponent.repository.ventaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class ventaService {

    @Autowired
    private ventaRepository ventaRepository;

    public List<venta> findAll() {
        return ventaRepository.findAll();
    }

    public venta findById(Integer id) {
        venta venta = ventaRepository.findById(id).orElse(null);
        return venta;
    }

    public venta save(venta venta) {
        return ventaRepository.save(venta);
    }

    public venta partialUpdate(venta venta) {
        venta existingVenta = ventaRepository.findById(venta.getId()).orElse(null);

        if (existingVenta != null) {

            if (venta.getNombre() != null) {
                existingVenta.setNombre(venta.getNombre());
            }

            if (venta.getPrecio() != null) {
                existingVenta.setPrecio(venta.getPrecio());
            }

            if (venta.getCantidad() != null) {
                existingVenta.setCantidad(venta.getCantidad());
            }

            if (venta.getTelefono() != null) {
                existingVenta.setTelefono(venta.getTelefono());
            }

            if (venta.getCorreo() != null) {
                existingVenta.setCorreo(venta.getCorreo());
            }

            return ventaRepository.save(existingVenta);
        }

        return null;
    }

    public void deleteById(Integer id) {
        ventaRepository.deleteById(id);
    }
}

