package PComponent_Eva3.PComponent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PComponent_Eva3.PComponent.model.marca;
import PComponent_Eva3.PComponent.repository.marcaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class marcaService {

    @Autowired
    private marcaRepository marcaRepository;

    public List<marca> findAll() {
        return marcaRepository.findAll();
    }

    public marca findById(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public marca save(marca marca) {
        return marcaRepository.save(marca);
    }

    public void deleteById(Integer id) {
        marcaRepository.deleteById(id);
    }

    public marca actualizarCategoria(Integer id, marca marcaActualizada) {
        marca marcaExistente = marcaRepository.findById(id).orElse(null);

        if (marcaExistente != null) {
            marcaExistente.setNombreMarca(marcaActualizada.getNombreMarca());
            marcaExistente.setDescripcion(marcaActualizada.getDescripcion());
            return marcaRepository.save(marcaExistente);
        }
        return null;
    }

    public marca partialUpdate(marca marca) {

        marca existingMarca = marcaRepository.findById(marca.getId()).orElse(null);

        if (existingMarca != null) {

            if (marca.getNombreMarca() != null) {
                existingMarca.setNombreMarca(marca.getNombreMarca());
            }
            if (marca.getDescripcion() != null) {
                existingMarca.setDescripcion(marca.getDescripcion());
            }
        
            return marcaRepository.save(existingMarca);

        }
        return null;
    }

    public boolean eliminarMarca(Integer id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

// REVISAR