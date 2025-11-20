package PComponent_Eva3.PComponent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PComponent_Eva3.PComponent.model.metodopago;
import PComponent_Eva3.PComponent.repository.metodopagoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class metodopagoService {

    @Autowired
    private metodopagoRepository metodoPagoRepository;

    public List<metodopago> findAll() {
        return metodoPagoRepository.findAll();
    }

    public metodopago findById(Integer id) {
        metodopago metodopago = metodoPagoRepository.findById(id).orElse(null);
        return metodopago;
    }

    public metodopago save(metodopago metodopago) {
        return metodoPagoRepository.save(metodopago);
    }

    public metodopago partialUpdate(metodopago metodopago) {
        metodopago existingMetodopago = metodoPagoRepository.findById(metodopago.getId()).orElse(null);
        
        if (existingMetodopago != null) {

            if (metodopago.getNombreMetodo() != null) {
                existingMetodopago.setNombreMetodo(metodopago.getNombreMetodo());
            }

            return metodoPagoRepository.save(existingMetodopago);
        }
        return null;
    }

    public void deleteById(Integer id) {
        metodoPagoRepository.deleteById(id);
    }
}
