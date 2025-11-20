package PComponent_Eva3.PComponent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PComponent_Eva3.PComponent.model.metodoenvio;
import PComponent_Eva3.PComponent.repository.metodoEnvioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class metodoenvioService {
    
    @Autowired
    private metodoEnvioRepository metodoEnvioRepository;

    public List<metodoenvio> findAll() {
        return metodoEnvioRepository.findAll();
    }

    public metodoenvio findById(Integer id) {
        metodoenvio metodoenvio = metodoEnvioRepository.findById(id).orElse(null);
        return metodoenvio;
    }

    public metodoenvio save(metodoenvio metodoenvio) {
        return metodoEnvioRepository.save(metodoenvio);
    }

    public metodoenvio partialUpdate(metodoenvio metodoenvio){
        metodoenvio existingMetodoenvio = metodoEnvioRepository.findById(metodoenvio.getId()).orElse(null);
        if (existingMetodoenvio != null) {
            if (metodoenvio.getNombre() != null) {
                existingMetodoenvio.setNombre(metodoenvio.getNombre());
            }

            if(metodoenvio.getTipoEnvio() != null) {
                existingMetodoenvio.setTipoEnvio(metodoenvio.getTipoEnvio());
            }

            if(metodoenvio.getCosto() != null) {
                existingMetodoenvio.setCosto(metodoenvio.getCosto());
            }

            if(metodoenvio.getTiempoEntrega() != null) {
                existingMetodoenvio.setTiempoEntrega(metodoenvio.getTiempoEntrega());
            }

            if(metodoenvio.getDireccion() != null) {
                existingMetodoenvio.setDireccion(metodoenvio.getDireccion());
            }

            if(metodoenvio.getTelefono() != null) {
                existingMetodoenvio.setTelefono(metodoenvio.getTelefono());
            }

            if(metodoenvio.getCorreo() != null) {
                existingMetodoenvio.setCorreo(metodoenvio.getCorreo());
            }

            if(metodoenvio.getIdVenta() != null) {
                existingMetodoenvio.setIdVenta(metodoenvio.getIdVenta());
            }

            return save(existingMetodoenvio);
        }
        return null;
    }

    public void deleteById(Integer id) {
        metodoEnvioRepository.deleteById(id);
    }
}
