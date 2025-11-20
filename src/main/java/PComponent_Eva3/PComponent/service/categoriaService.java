package PComponent_Eva3.PComponent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PComponent_Eva3.PComponent.repository.categoriaRepository;
import jakarta.transaction.Transactional;
import PComponent_Eva3.PComponent.model.categoria;

@Service
@Transactional
@SuppressWarnings("null")
public class categoriaService {

    @Autowired
    private categoriaRepository categoriaRepository;

    public List<categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public categoria save(categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public categoria partialUpdate(categoria categoria) {
        categoria existing = categoriaRepository.findById(categoria.getId()).orElse(null);
        if (existing == null) {
            return null;
        }

        if (categoria.getNombreCategoria() != null) {
            existing.setNombreCategoria(categoria.getNombreCategoria());
        }

        if (categoria.getDescripcion() != null) {
            existing.setDescripcion(categoria.getDescripcion());
        }

        return categoriaRepository.save(existing);
    }

    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
